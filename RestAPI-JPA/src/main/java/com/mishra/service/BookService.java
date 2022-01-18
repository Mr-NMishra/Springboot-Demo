package com.mishra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mishra.dao.BookRepository;
import com.mishra.entities.Author;
import com.mishra.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	// sending all Books
	public List<Book> findAllBook() {
		List<Book> bookList = (List<Book>) bookRepository.findAll();
		System.out.println("----" + bookList);
		return bookList;
	}

	// sending only specific book
	public Book getBookById(int BookId) {
		Book book = null;
		try {
			book = bookRepository.findById(BookId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// adding book to our temp or fake database
	public Book addBook(Book book) {
		try {
			if (book.getbId() != 0) {
				bookRepository.save(book);
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Deleting book by ID

	public String removeBookById(int bookId) {
		// we are using stream filter method to filter out our list
		// and saving new list to our old list, here we just skip the
		// book whose id is matched

		try {
			bookRepository.deleteById(bookId);
			return "Deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// updatingBook
	public Book updateBook(Book book, int id) {
		try {
			Book savedBook=getBookById(id);
			savedBook.setTitle(book.getTitle());
			Author author= book.getAuthor();
			int authid=author.getId();
			String name=author.getName();
			String language=author.getLanguage();
			Book authBook=author.getBook();
			
			savedBook.setAuthor(new Author(authid, name, language));
//			savedBook.setAuthor(book.getAuthor());
			bookRepository.save(savedBook);
			return savedBook;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
