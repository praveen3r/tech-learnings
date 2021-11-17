package com.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.JavaToJson;
import com.demo.dto.RestTemplateVO;

@RestController
@RequestMapping("/restTemplate1")
public class TestRestTemplateGetController {

	//http://localhost:8080/spring-mvc/restTemplate1/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public ResponseEntity<Void> rest1() {
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public ResponseEntity<String> rest2() {
		ResponseEntity<String> response = new ResponseEntity<String>("Success",HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public ResponseEntity<RestTemplateVO> rest3() {
		RestTemplateVO jsonVO = new RestTemplateVO();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("clerk");
		ResponseEntity<RestTemplateVO> response = new ResponseEntity<RestTemplateVO>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest4/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> rest4(@PathVariable String id) {
		ResponseEntity<String> response = new ResponseEntity<String>(id,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public ResponseEntity<String> rest4WithParam(@RequestParam("id") String id) {
		ResponseEntity<String> response = new ResponseEntity<String>(id,HttpStatus.OK);
		return response;
	}
}
