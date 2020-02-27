package com.ibm.training.ui;
import com.ibm.training.bean.*;
import com.ibm.training.service.*;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springAppContext.xml");
        
        Scanner scan = new Scanner(System.in);
        SpringBean b = new SpringBean();
        
        SpringServiceClass service = context.getBean("serviceclass", SpringServiceClass.class);
        
        while(true) {
        	System.out.println("Press 1 to insert new customer");
        	System.out.println("press 2 to update name of registered customer");
        	System.out.println("press 3 to update contact number for an existing customer");
        	System.out.println("press 4 to deposit amount");
        	System.out.println("press 5 to withdraw amount");
        	System.out.println("press 6 to transfer funds");
        	System.out.println("press 7 to print balance of an account");
        	System.out.println("press 8 to print all transactions");
        	System.out.println("press 9 to print account details");
        	System.out.println("press 10 to halt");
        	int n = scan.nextInt();
        	scan.nextLine();
        	switch(n) {
        	case 1:
        		new SpringInsert(b,service);
        		break;
        	case 2:
        		new SpringUpdateName(b,service);
        		break;
        	case 3:
        		new SpringUpdateNumber(b,service);
        		break;
        	case 4:
        		new SpringDepositFunds(b,service);
        		break;
        	case 5:
        		new SpringWithdrawFunds(b,service);
        		break;
        	case 6:
        		new SpringFundTransfer(b,service);
        		break;
        	case 7:
        		new SpringPrintBalance(b,service);
        		break;
        	case 8:
        		new SpringPrintAllTransactions(b,service);
        		break;
        	case 9:
        		new SpringPrintAllData(b,service);
        		break;
        	case 10:
        		n=11;
        		break;
        		default:
        			break;
        	}
            if(n==11)
        	break;
        }
    }
}
