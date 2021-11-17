/*package com.demo.utils;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.rest.controller.ResultEntity;

@ControllerAdvice
public class GlobalRestfulExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResultEntity<String> handleValidationException(final MethodArgumentNotValidException ex) throws IOException {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(false);
		response.setStatusMsg("Invalid data");
		return response;
	}
}
*/