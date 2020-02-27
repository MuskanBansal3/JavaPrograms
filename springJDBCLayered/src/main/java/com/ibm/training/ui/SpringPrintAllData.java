package com.ibm.training.ui;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringPrintAllData {
	public SpringPrintAllData(SpringBean b, SpringServiceClass service) {
		for(SpringBean val: service.serveGetAllData(b)) {
			System.out.println(val.getAccountNumber());
			System.out.println(val.getHolderName());
			System.out.println(val.getHolderContactNumber());
			System.out.println(val.getAccountBalance());
			System.out.println("***************************");
		}
	}

}