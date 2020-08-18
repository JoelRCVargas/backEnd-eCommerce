package com.beecode.exceptions;

public class InvalidMailException extends Exception {

	private static final long serialVersionUID = 5276860772131653710L;
	
	private static final String DESCRIPTION = "Incorrect format";
	
	public InvalidMailException() {
		super(DESCRIPTION);
	}
	
	public InvalidMailException(String message) {
		super(DESCRIPTION + ". "+ message);
	}

}
