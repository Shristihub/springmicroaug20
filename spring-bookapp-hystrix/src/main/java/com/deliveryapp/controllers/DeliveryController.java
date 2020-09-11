package com.deliveryapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deliveryapp.model.Book;
import com.deliveryapp.service.DeliveryService;

@RestController
@RequestMapping("delivery-service")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@GetMapping("/deliver-one/{bookid}")
	public Book deliverOneBook(@PathVariable("bookid")int bookid) {
		return deliveryService.getById(bookid);
	}
	@GetMapping("/deliver-by-category/{category}")
	public List<Book> orderBookByCategory(@PathVariable("category")String category) {
		return deliveryService.getByCategory(category);
	}
	@GetMapping("/delivery-books")
	public List<Book> getAllBooks(){
		return deliveryService.getBooks();
	}

}
