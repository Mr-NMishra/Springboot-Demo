package com.mishra.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	private String title;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bId, String title, Author author) {
		super();
		this.bId = bId;
		this.title = title;
		this.author = author;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", title=" + title + ", author=" + author + "]";
	}

}
