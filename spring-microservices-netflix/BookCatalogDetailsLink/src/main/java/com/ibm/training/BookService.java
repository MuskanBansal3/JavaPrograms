package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.training.BookDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService{
	
	

	@HystrixCommand(fallbackMethod = "stillWorks")
	public Iterable<BookDetails> getAllBookData()
	{
		//String anotherServiceUrlFriendly="http://bookdetailservice/Bdetails/books";
	String anotherServiceUrlFriendly="http://localhost:8031/Bdetails/books";
		
		
		//create the RestTemplate
		RestTemplate template=new RestTemplate();

		// Hit the other micro-service URL
	//	return template.getForObject(anotherServiceUrl, String.class);
		return (java.lang.Iterable<BookDetails>) template.getForObject(anotherServiceUrlFriendly, 
				Object.class);
		
		
	}
	
public Iterable<BookDetails> stillWorks()
{
	return null;

}
}
