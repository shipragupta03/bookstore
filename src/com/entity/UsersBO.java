package com.entity;

public class UsersBO {

	int userId;
	String userName;
	BooksBO books;
	
	public UsersBO() {
		
	}
	
	public UsersBO(int userId,String userName,BooksBO books) {
		this.userId = userId;
		this.userName = userName;
		this.books = books;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BooksBO getBooks() {
		return books;
	}

	public void setBooks(BooksBO books) {
		this.books = books;
	}
}
