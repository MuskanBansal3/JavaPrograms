package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.bean.BookDetails;
import com.ibm.training.repository.Repository;

@Service
public class BookService {

	@Autowired
	Repository repo;
	
	public void addBookDetail(BookDetails book) {
		repo.save(book);
		
	}

	public Iterable<BookDetails> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	

}
