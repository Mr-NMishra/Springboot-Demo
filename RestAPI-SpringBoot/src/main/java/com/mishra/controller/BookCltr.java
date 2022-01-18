package com.mishra.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mishra.entities.Book;
import com.mishra.service.BookService;

@RestController
public class BookCltr {
	@Autowired
	private BookService bookService;

	
	//Getting list of all Books
	@GetMapping("/books")
	public List<Book> Test() {
		return bookService.findAllBook();
	}
	
	//Getting books using Id
	@GetMapping("books/{id}")
	public Book findByBookId(@PathVariable("id") int bookId) {
		return bookService.getBookById(bookId);
	}
	
	//Adding Books 
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping("books/{id}")
	public void deleteById(@PathVariable("id") int bookId) {
		 bookService.removeBookById(bookId);
	}
}
