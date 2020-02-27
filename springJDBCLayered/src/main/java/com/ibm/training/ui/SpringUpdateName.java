package com.ibm.training.ui;


import java.util.Scanner;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringUpdateName {
	public SpringUpdateName(SpringBean b,SpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number to be updated");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		b.setAccountNumber(accountNumber);
		
		System.out.println("Enter the new name");
		String newName = scan.nextLine();
		b.setHolderName(newName);
		if(service.serveUpdateName(b))
			System.out.println("Name Updated");
		else
			System.out.println("Name not updated");
		
	}
}