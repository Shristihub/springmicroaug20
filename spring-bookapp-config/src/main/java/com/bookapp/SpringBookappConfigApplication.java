package com.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBookappConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappConfigApplication.class, args);
	}

}
