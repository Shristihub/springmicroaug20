package com.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	Integer bookid;
	String title;
	String author;
	String category;
	double price;
	
}
