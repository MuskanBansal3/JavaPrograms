package com.ibm.test.dao;

import java.util.HashMap;

import java.util.Map;

import com.ibm.test.bean.Person;

public interface DaoInterface {
	
	
	void storeIntoMap(Person person);
	Map<Integer,Person> displayPersons();

}
