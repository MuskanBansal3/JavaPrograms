package com.ibm.test.service;

import java.util.Map;

import com.ibm.test.bean.Person;

public interface ServiceInterface {
	public static final String USERNAMEPATTERN="[A-Z][a-z]{9}";
	boolean validateUserName(String userName);
	void storeIntoMap(Person person);
	//public abstract
	Map<Integer,Person> displayPersons();
}
