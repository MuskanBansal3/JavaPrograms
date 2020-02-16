package com.ibm.test.service;

import java.util.Map;

import com.ibm.test.bean.Person;
import com.ibm.test.dao.DaoClass;

public  class ServiceClass implements ServiceInterface {

	DaoClass dao = new DaoClass();
	
	@Override
	public boolean validateUserName(String userName) {
		if(userName.matches(USERNAMEPATTERN))
			return true;
		else
			return false;
	}
	
public void storeIntoMap(Person person){
		dao.storeIntoMap(person);
		
	}
//	public void test(){
//		
//	}

	@Override
	public Map<Integer, Person> displayPersons() {
		
		return dao.displayPersons();
	}


}
