package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/BdetailsLink")
public class RestController {
	
	

	@Autowired
	RestTemplate template;

@Autowired
BookService service;

@RequestMapping("/all")
public Iterable<BookDetails> getAllBookData()
{
	return service.getAllBookData();
}

}