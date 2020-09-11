package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookRepository;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	@Override
	public Book getBookById(int bookid) {
		return bookRepository.findById(bookid).get();
	}
	@Override
	public List<Book> getBookByCategory(String category) {
		return bookRepository.findByCategory(category);
	}
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
}
