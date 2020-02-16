package com.ibm.test.dao;

import java.util.HashMap;

import java.util.Map;

import com.ibm.test.bean.Person;

public class DaoClass implements DaoInterface{

	private Map<Integer,Person> persons=new 
			HashMap<Integer,Person>();
	
	@Override
	public void storeIntoMap(Person person) {
	
		persons.put(1, person);
		
	}
	
	public Map<Integer,Person>displayPersons(){
		return persons;
		
		
	}
	

}
