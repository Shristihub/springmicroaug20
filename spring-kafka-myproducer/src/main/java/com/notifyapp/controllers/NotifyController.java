package com.notifyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notifyapp.service.NotifyService;

@RestController
@RequestMapping("/notify-service")
public class NotifyController {

	@Autowired
	NotifyService notifyService;
	
	@GetMapping("/greet/{message}")
	public String greetMessage(@PathVariable("message")String message) {
		notifyService.sendMessage(message);
		return "success";
	} 
}
