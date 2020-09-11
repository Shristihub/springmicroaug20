package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/book-by-id/{bookid}")
	public Book getBookById(@PathVariable("bookid")int bookid) {
		return bookService.getBookById(bookid);
	}
	@GetMapping("/book-by-category/{category}")
	public List<Book> getBookByCategory(@PathVariable("category")String category) {
		return bookService.getBookByCategory(category);
	}
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}

}
