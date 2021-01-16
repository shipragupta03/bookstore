package com.entity;

public class BooksBO {

	String bookName;
	int ISBNId;
	int quantity;
	
	public BooksBO() {
		
	}
	
	public BooksBO(String bookName,int ISBNId,int quantity) {
		this.bookName = bookName;
		this.ISBNId = ISBNId;
		this.quantity = quantity;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getISBNId() {
		return ISBNId;
	}
	public void setISBNId(int iSBNId) {
		ISBNId = iSBNId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
