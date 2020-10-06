package com.userapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	String data; 

	@KafkaListener(topics = {"mytopic"}, groupId="group-id")
	public void  consume(String message){
		System.out.print(message);
		this.data = message;
	}
	
	public String getMessage() {
		return data; 
	}
}
