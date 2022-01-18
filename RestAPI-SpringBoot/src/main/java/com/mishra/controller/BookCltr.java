package com.mishra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Book>>  Test() {
		List<Book> list=bookService.findAllBook();
		//checking list is empty or not
		if(list.isEmpty()) {
			//using status Static method of Response class
			//and passing HttpStatus
			//here build method is used to creae response object
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}else {
			//if list having elements then we should
			//pass response with body i.e. elements
			return ResponseEntity.of(Optional.of(list));
		}
		//bookService.findAllBook();
	}
	
	//Getting books using Id
	@GetMapping("/books/{id}")
	public Book findByBookId(@PathVariable("id") int bookId) {
		return bookService.getBookById(bookId);
	}
	
	//Adding Books 
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	//Deleting Book
	@DeleteMapping("/books/{id}")
	public void deleteById(@PathVariable("id") int bookId) {
		 bookService.removeBookById(bookId);
	}
	
	
	//updatingBook
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable("id") int bookId) {
		return bookService.updateBook(book,bookId);
	}
}
