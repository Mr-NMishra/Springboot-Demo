package com.mishra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mishra.entities.Book;
@Service
public class BookService {

	private static List<Book> bookList= new ArrayList<>();

	static{
		bookList.add(new Book(101, "Java", "Pearson"));
		bookList.add(new Book(102, "Sql", "Nagrajan"));
		bookList.add(new Book(103, "SpringBoot", "Spring"));
	}
	
	public List<Book> findAllBook(){
		return bookList;
	}
	
}
