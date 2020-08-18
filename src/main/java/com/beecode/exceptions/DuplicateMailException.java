package com.beecode.exceptions;

public class DuplicateMailException extends Exception {
	
	private static final long serialVersionUID = 2981645116163930187L;
	public static final String DESCRIPTION = "Duplicate mail";
	
	
	public DuplicateMailException() {
		super(DESCRIPTION);
	}
	
	public DuplicateMailException(String message) {
		super(DESCRIPTION + ". "+ message);
	}

}
