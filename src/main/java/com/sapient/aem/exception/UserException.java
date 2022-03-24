package com.sapient.aem.exception;

public class UserException extends Exception{
	public UserException() {

	}

	public UserException(String message) {
		super(message);
	}

	public UserException(String message,Throwable t) {
		super(message,t);
	}
}
