package com.beecode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.beecode.entity.Error;
import com.beecode.exceptions.DuplicateMailException;
import com.beecode.exceptions.InvalidMailException;

@RestControllerAdvice
public class ExceptionConfig {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({DuplicateMailException.class})
	@ResponseBody
	public Error badRequestException(Exception e, HttpServletRequest request) {
		Error error = new Error(e, request.getRequestURI().toString());
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({InvalidMailException.class})
	@ResponseBody
	public Error invalidRequestException(Exception e, HttpServletRequest request) {
		Error error = new Error(e, request.getRequestURI().toString());
		return error;
	}

}
