package com.bookapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document
public class Book {

	@Id
	Integer bookid;
	String title;
	String author;
	String category;
	double price;
	
}
