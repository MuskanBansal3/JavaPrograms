package com.ibm.test.ui;

import java.util.Scanner;

import com.ibm.test.bean.Person;
import com.ibm.test.dao.DaoInterface;
import com.ibm.test.service.ServiceClass;
import com.ibm.test.service.ServiceInterface;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
	
		ServiceInterface service=
				new ServiceClass();
		
		 //service.test();//error 
		String name;
		while(true){
		
		System.out.println("enter name");
		 name=scan.next();
		
		boolean isValid= service.validateUserName(name);
		/*if(isValid)
			System.out.println("right");
		else
			System.out.println("wrong");
		*/
		if(isValid)
			break;
		}
		
		System.out.println("enter age ");
		String age=scan.next();
		
		Person person = new Person();
		person.setAge(Integer.parseInt(age));
		person.setName(name);
		
		
		service.storeIntoMap(person);
		
		//System.out.println(DaoInterface.persons);
		
		System.out.println(service.displayPersons());
	}

}
