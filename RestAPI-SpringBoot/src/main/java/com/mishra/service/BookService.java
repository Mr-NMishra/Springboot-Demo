package com.mishra.service;

import java.util.ArrayList;
import java.util.List;
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

}
