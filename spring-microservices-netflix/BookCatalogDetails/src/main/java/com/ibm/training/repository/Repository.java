package com.ibm.training.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.training.bean.BookDetails;

public interface Repository extends CrudRepository<BookDetails, Integer>{
	
	

}
