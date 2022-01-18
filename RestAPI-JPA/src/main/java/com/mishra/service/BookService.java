package com.mishra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mishra.dao.BookRepository;
import com.mishra.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	//private static List<Book> bookList = new ArrayList<>();

	// sending all Books
	public List<Book> findAllBook() {
		List<Book> bookList=(List<Book>)  bookRepository.findAll();
		return bookList;
	}

	// sending only specific book
	public Book getBookById(int BookId) {
		Book book=null;
		try {
			book=bookRepository.findById(BookId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// adding book to our temp or fake database
	public  Book addBook(Book book) {
		try {
			if(book.getbId()!=0) {
				bookRepository.save(book);
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Deleting book by ID
	/*
	 * public Book removeBookById(int bookId) { var wrapper= new Object() {Book
	 * flag=null;}; // we are using stream filter method to filter out our list //
	 * and saving new list to our old list, here we just skip the // book whose id
	 * is matched Stream<Book> stream = bookList.stream(); bookList =
	 * stream.filter(book -> {
	 * 
	 * if (book.getbId() != bookId) { return true; } else { wrapper.flag=book;
	 * return false; } }).collect(Collectors.toList());
	 * 
	 * return wrapper.flag; }
	 * 
	 * // updatingBook public Book updateBook(Book book, int id) { var outerFlag=
	 * new Object() { Book flag=null;}; // using java stream feature // here map is
	 * used to updating or copy map bookList = bookList.stream().map(streamBook -> {
	 * 
	 * if (streamBook.getbId() == id) { streamBook.setAuthor(book.getAuthor());
	 * streamBook.setTitle(book.getTitle()); outerFlag.flag=streamBook; } return
	 * streamBook; }).collect(Collectors.toList()); System.out.println(book); return
	 * outerFlag.flag; }
	 */
}
