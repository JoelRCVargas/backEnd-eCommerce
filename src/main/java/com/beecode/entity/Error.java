package com.beecode.entity;

public class Error {
	
	private String exception;
	private String message;
	private String path;
	
	public Error(Exception exception, String path) {
		this(exception.getClass().getSimpleName(), exception.getMessage(), path);
	}
	
	public Error(String exception, String message, String path) {
		this.exception = exception;
		this.message = message;
		this.path = path;
	}
	
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
