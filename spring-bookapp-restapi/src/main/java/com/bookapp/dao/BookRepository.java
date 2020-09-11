package com.bookapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

	// derived queries
	List<Book> findByCategory(String category);
}
