package com.ibm.training.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.training.bean.SpringBean;

@Component("serviceinterface")
public interface SpringServiceInterface {
	boolean serveInsert(SpringBean b);
	boolean serveUpdateName(SpringBean b);
	boolean serveUpdateNumber(SpringBean b);
	int serveGetBalance(SpringBean b);
	boolean serveDepositInAccount(SpringBean b);
	boolean serveWithdrawFromAccount(SpringBean b);
	List<SpringBean> serveGetTransaction(SpringBean b);
	List<SpringBean> serveGetAllData(SpringBean b);
}
