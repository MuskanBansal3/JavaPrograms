package com.ibm.training.dao;
import com.ibm.training.ui.*;
import com.ibm.training.bean.*;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository("daointerface")
public interface SpringDaoInterface {
	boolean insertData(SpringBean b);
	boolean updateName(SpringBean b);
	boolean updateNumber(SpringBean b);
	int getBalance(SpringBean b);
	boolean checkBalance(SpringBean b);
	boolean depositInAccount(SpringBean b);
	boolean withdrawFromAccount(SpringBean b);
	List<SpringBean> getTransaction(SpringBean b);
	List<SpringBean> getAllData(SpringBean b);
}