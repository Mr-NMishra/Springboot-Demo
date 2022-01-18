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

	// Getting list of all Books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> Test() {
		List<Book> list = bookService.findAllBook();
		// checking list is empty or not
		if (list.isEmpty()) {
			// using status Static method of Response class
			// and passing HttpStatus
			// here build method is used to creae response object
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} else {
			// if list having elements then we should
			// pass response with body i.e. elements
			return ResponseEntity.of(Optional.of(list));
		}
		// bookService.findAllBook();
	}

	// Getting books using Id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> findByBookId(@PathVariable("id") int bookId) {
		// first we check book is present or not in service
		Book book = bookService.getBookById(bookId);
		if (book != null)
			// if present then add to reponse body
			return ResponseEntity.of(Optional.of(book));
		else
			// if not the return with http code
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Adding Books
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book newbook) {
		Book book = bookService.addBook(newbook);
		if (book != null)
			return ResponseEntity.ok(book);
		else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	// Deleting Book
	/*
	 * @DeleteMapping("/books/{id}") public ResponseEntity<Void>
	 * deleteById(@PathVariable("id") int bookId) { Book flag =
	 * bookService.removeBookById(bookId); if (flag != null) {
	 * bookService.removeBookById(bookId); return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build(); } else { // TODO:
	 * handle exception return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 * } }
	 * 
	 * // updatingBook
	 * 
	 * @PutMapping("/books/{id}") public ResponseEntity<Book>
	 * updateBook(@RequestBody Book book,@PathVariable("id") int bookId) { Book
	 * flag= bookService.updateBook(book,bookId); if(flag!=null) { return
	 * ResponseEntity.ok(flag); }else return
	 * ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); }
	 */
}
