package com.deliveryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deliveryapp.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DeliveryService {
	
	@Autowired
	RestTemplate restTemplate;
	public final String URI = "http://localhost:8082/order-service";
	
	@HystrixCommand(fallbackMethod = "fallbackGetById")
	public Book getById(int bookid) {
		String url = URI+"/orderbook-by-id/"+bookid;
		return restTemplate.getForObject(url, Book.class);
	}
	
	@HystrixCommand(fallbackMethod = "fallbackGetByCategory")
	public List<Book> getByCategory(String category) {
		String url = URI+"/book-by-category/"+category;
		return restTemplate.getForObject(url, List.class);
	}
	@HystrixCommand(fallbackMethod = "fallbackGetBooks")
	public List<Book> getBooks(){
		String url = URI+"/books";
		return restTemplate.getForObject(url, List.class);
	}
	
	public Book fallbackGetById(int bookid) {
		return new Book(0,"Bo title","","",0);
	}	
	public List<Book> fallbackGetByCategory(String category) {
		return new ArrayList<>();
	}	
	public List<Book> fallbackGetBooks(){
		return new ArrayList<>();
	}

}
