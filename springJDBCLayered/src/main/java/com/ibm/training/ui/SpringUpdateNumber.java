package com.ibm.training.ui;




import java.util.Scanner;

import com.ibm.training.bean.*;
import com.ibm.training.service.SpringServiceClass;

public class SpringUpdateNumber {

	public SpringUpdateNumber(SpringBean b, SpringServiceClass service) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number to be updated");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		b.setAccountNumber(accountNumber);
		
		System.out.println("Enter the new Number");
		double newNumber = scan.nextDouble();
		scan.nextLine();
		b.setHolderContactNumber(newNumber);
		
		if(service.serveUpdateNumber(b))
			System.out.println("Number Updated");
		else
			System.out.println("Number not Updated");
		
		
	}
}