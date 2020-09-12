package com.checkapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.checkapp.model.Book;

@RestController
@RequestMapping("check-service")
public class RibbonController {
	
	@Autowired
	RestTemplate restTemplate;
	public final String SERVICENAME = "ORDER-SERVICE";
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	private final String BASEURL = "http://ORDER-SERVICE/order-service";
	
	@GetMapping("/check-one/{bookid}")
	public Book chcekBookById(@PathVariable("bookid")int bookid) {
		ServiceInstance instance = loadBalancerClient.choose(SERVICENAME);
		int port = instance.getPort();
		System.out.println("*********selected port is*********  "+ port);
		String url = BASEURL+"/orderbook-by-id/"+bookid;
		return restTemplate.getForObject(url, Book.class);
	}
	@GetMapping("/check-by-category/{category}")
	public List<Book> checkBookByCategory(@PathVariable("category")String category) {
		ServiceInstance instance = loadBalancerClient.choose(SERVICENAME);
		int port = instance.getPort();
		System.out.println("*********selected port is*********  "+ port);
		String url = BASEURL+"/book-by-category/"+category;
		return restTemplate.getForObject(url, List.class);
	}
	@GetMapping("/check-books")
	public List<Book> getAllBooks(){
		ServiceInstance instance = loadBalancerClient.choose(SERVICENAME);
		int port = instance.getPort();
		System.out.println("*********selected port is*********  "+ port);
		String url = BASEURL+"/books";
		return restTemplate.getForObject(url, List.class);
	}

}
