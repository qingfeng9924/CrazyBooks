package com.crazybooks.etity;

import java.sql.Timestamp;

/**
 * Addbooks entity. @author MyEclipse Persistence Tools
 */

public class Addbooks implements java.io.Serializable {

	// Fields

	private Integer id;
	private Books books;
	private Timestamp manipulateTime;

	// Constructors

	/** default constructor */
	public Addbooks() {
	}

	/** full constructor */
	public Addbooks(Books books, Timestamp manipulateTime) {
		this.books = books;
		this.manipulateTime = manipulateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Timestamp getManipulateTime() {
		return this.manipulateTime;
	}

	public void setManipulateTime(Timestamp manipulateTime) {
		this.manipulateTime = manipulateTime;
	}

}