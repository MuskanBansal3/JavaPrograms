package com.ibm.training.service;
import com.ibm.training.dao.*;

import com.ibm.training.bean.SpringBean;
import java.util.List;
import javax.sql.DataSource;


import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("serviceclass")
public class SpringServiceClass implements SpringServiceInterface {

	 @Autowired
	 SpringDaoClass d;
	 
	 public SpringDaoClass SpringServiceClass() {
		 ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("springAppContext.xml");
		 d= context.getBean("daoclass",SpringDaoClass.class);
		 return d;
	 }
	 
	 @Override
	 public boolean serveInsert(SpringBean b) {
		 return d.insertData(b);
	 }
	 
	 @Override
	 public boolean serveUpdateName(SpringBean b) {
		 return d.updateName(b);
	 }
	 
	 @Override
	 public boolean serveUpdateNumber(SpringBean b) {
		 return d.updateNumber(b);
	 }

	 @Override
	 public int serveGetBalance(SpringBean b) {
		 return d.getBalance(b);
	 }
	 
	 @Override
	 public boolean serveDepositInAccount(SpringBean b) {
		 return d.depositInAccount(b);
	 }
	 
	 @Override
	 public boolean serveWithdrawFromAccount(SpringBean b) {
		 return d.withdrawFromAccount(b);
	 }
	 
	 public List<SpringBean> serveGetTransaction(SpringBean b){
		 return d.getTransaction(b);
	 }
	 
	 public List<SpringBean> serveGetAllData(SpringBean b){
		 return d.getAllData(b);
	 }
}
