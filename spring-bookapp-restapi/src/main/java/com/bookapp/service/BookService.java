package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface BookService {
	
	Book getBookById(int bookid);
	List<Book> getBookByCategory(String category);
	List<Book> getAllBooks();
}
