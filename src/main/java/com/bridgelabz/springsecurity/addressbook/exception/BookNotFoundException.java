package com.bridgelabz.springsecurity.addressbook.exception;

public class BookNotFoundException extends RuntimeException{
	
	private String message;
	
	public BookNotFoundException(String message) {
        super(message);
    }

}
