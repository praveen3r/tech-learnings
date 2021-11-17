package com.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ArithmeticException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleArithmeticException(Exception e){
		System.out.println("coming to global handleArithmeticException");
		return "error/error";
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e){
		System.out.println("coming to global handleException");
		return "error/error";
		
	}
}
