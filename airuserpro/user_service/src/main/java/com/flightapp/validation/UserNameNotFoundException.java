package com.flightapp.validation;

public class UserNameNotFoundException extends RuntimeException{
	String message;

	public UserNameNotFoundException(String message) {
		super(message);
	}

}
