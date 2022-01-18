package com.mishra.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Author {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private String language;
	@ManyToOne
	private Book book;

	public Author(int id, String name, String language) {
		super();
		Id = id;
		this.name = name;
		this.language = language;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Author [Id=" + Id + ", name=" + name + ", language=" + language + "]";
	}

}
