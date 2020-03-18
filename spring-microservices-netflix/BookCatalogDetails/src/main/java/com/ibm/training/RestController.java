package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.training.bean.BookDetails;
import com.ibm.training.service.BookService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("Bdetails")
public class RestController {
	@Autowired
	BookService service;

	@PostMapping("/books")
	void addBookDetail(@RequestBody BookDetails book) {
		service.addBookDetail(book);
	}

	@GetMapping("/books")
	Iterable<BookDetails> getAllBooks() {
		return service.getAllBooks();

	}

}
