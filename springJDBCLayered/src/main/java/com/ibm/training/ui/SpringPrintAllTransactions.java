package com.ibm.training.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringPrintAllTransactions {

	public SpringPrintAllTransactions(SpringBean b, SpringServiceClass service) {
		for(SpringBean val: service.serveGetTransaction(b)) {
			System.out.println(val.getTransactionNumber());
			System.out.println(val.getAccountNumber());
			System.out.println(val.getTransactionAmount());
			System.out.println(val.getTransactionTime());
			System.out.println("***************");
		}
		}
}
