package com.demo.rest.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.custom.validation.RestfulValidationVOValidator1;
import com.demo.dto.RestfulValidationVO1;

@RestController
@RequestMapping("/restValidtn1/")
public class RestfulValidationController1 {

	@InitBinder()
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RestfulValidationVOValidator1());
	}

	//http://localhost:8080/spring-mvc/restValidtn1/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.POST)
	public ResponseEntity<Void> rest1(@Valid @RequestBody RestfulValidationVO1 jsonVO) {
		System.out.println(jsonVO.getId());
		System.out.println(jsonVO.getName());
		System.out.println(jsonVO.getPassportNumber());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResultEntity<String> handleValidationException(final MethodArgumentNotValidException ex) throws IOException {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(false);
		response.setStatusMsg("Invalid data");
		return response;
	}

}
