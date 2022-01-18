package com.mishra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
		Book book=null;
		try {
			Stream<Book> stream = bookList.stream();
			stream = stream.filter(streamBook -> streamBook.getbId() == BookId);
			book = stream.findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------->Book-----"+book);
		return book;
	}

	// adding book to our temp or fake database
	public Book addBook(Book book) {
		bookList.add(book);
		System.out.println(book);
		return book;
	}

	// Deleting book by ID
	public void removeBookById(int bookId) {

		// we are using stream filter method to filter out our list
		// and saving new list to our old list, here we just skip the
		// book whose id is matched
		Stream<Book> stream = bookList.stream();
		bookList = stream.filter(book -> {
			if (book.getbId() != bookId) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
	}

	// updatingBook
	public Book updateBook(Book book, int id) {
		// using java stream feature
		// here map is used to updating or copy map
		System.out.println(book);
		bookList = bookList.stream().map(streamBook -> {

			if (streamBook.getbId() == id) {

				streamBook.setAuthor(book.getAuthor());
				streamBook.setName(book.getName());
				System.out.println(book);
			}
			return streamBook;
		}).collect(Collectors.toList());
		System.out.println(book);
		return book;
	}

}
