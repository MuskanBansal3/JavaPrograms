package com.ibm.training.ui;

import java.util.Scanner;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringWithdrawFunds {

	public SpringWithdrawFunds(SpringBean b, SpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		b.setTransactionTime(d1);
		
		System.out.println("Enter Withdrawn Amount");
		int amountDeposit = scan.nextInt();
		b.setTransactionAmount(amountDeposit);
		
		System.out.println("Enter the withdarwer contact number");
		double holderContactNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(holderContactNumber);
		
		if(service.serveWithdrawFromAccount(b))
			System.out.println("Amount Withrawn");
		else
			System.out.println("Amount not Withdrawn");
	}

}