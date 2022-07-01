package com.flightapp.validation;

public class PnrNumberNotFound extends RuntimeException{
	


	private static final long serialVersionUID = 1L;
	private String message;

	public PnrNumberNotFound(){
		
	}
	public PnrNumberNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
