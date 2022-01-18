package com.mishra.entities;

public class Book {
	private int bId;
	private String name;
	private String author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bId, String name, String author) {
		super();
		this.bId = bId;
		this.name = name;
		this.author = author;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", name=" + name + ", author=" + author + "]";
	}

}
