package com.mishra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mishra.entities.Book;
import com.mishra.service.BookService;

@RestController
public class BookCltr {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> Test() {
		return bookService.findAllBook();
	}
}
