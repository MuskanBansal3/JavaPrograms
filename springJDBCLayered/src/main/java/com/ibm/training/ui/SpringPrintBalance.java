package com.ibm.training.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringPrintBalance {
	public SpringPrintBalance(SpringBean b, SpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the acount holder contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		System.out.println(service.serveGetBalance(b));
	}
}