package com.mishra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.mishra.entities.Book;

@Service
public class BookService {

	private static List<Book> bookList = new ArrayList<>();

	static {
		bookList.add(new Book(101, "Java", "Pearson"));
		bookList.add(new Book(102, "Sql", "Nagrajan"));
		bookList.add(new Book(103, "SpringBoot", "Spring"));
	}

	// sending all Books
	public List<Book> findAllBook() {
		return bookList;
	}

	// sending only specific book
	public Book getBookById(int BookId) {

		System.out.println("start-----------------------------------------------");
		Stream<Book> stream = bookList.stream();
		stream = stream.filter(book -> book.getbId() == BookId);
		Book book = stream.findFirst().get();
		return book;
	}
	
	//adding book to our temp or fake database
	public Book addBook(Book book) {
		bookList.add(book);
		System.out.println(book);
		return book;
	}
	
	//Deleting book by ID
	public void removeBookById(int bookId) {
		Stream<Book> stream= bookList.stream();
		bookList= stream.filter(book->{
			if(book.getbId()!=bookId) {
				return true;
			}else{
				return false;
			}
		}).collect(Collectors.toList());
	}

}
