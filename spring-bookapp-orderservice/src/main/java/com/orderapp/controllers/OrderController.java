package com.orderapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.model.Book;

@RestController
@RequestMapping("order-service")
public class OrderController {
	
	@Autowired
	RestTemplate restTemplate;
	public final String URI = "http://localhost:8081/book-service";
	
	@GetMapping("/orderbook-by-id/{bookid}")
	public Book orderBookById(@PathVariable("bookid")int bookid) {
		String url = URI+"/book-by-id/"+bookid;
		return restTemplate.getForObject(url, Book.class);
	}
	@GetMapping("/book-by-category/{category}")
	public List<Book> orderBookByCategory(@PathVariable("category")String category) {
		String url = URI+"/book-by-category/"+category;
		return restTemplate.getForObject(url, List.class);
	}
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		String url = URI+"/books";
		return restTemplate.getForObject(url, List.class);
	}

}
