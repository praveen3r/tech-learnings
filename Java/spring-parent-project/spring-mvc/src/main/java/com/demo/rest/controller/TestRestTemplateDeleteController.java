package com.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.RestTemplateVO;

@RestController
@RequestMapping("/restTemplate4")
public class TestRestTemplateDeleteController {
	
	@RequestMapping(value = "rest1/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> rest1(@PathVariable("id") String id) {
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "rest2/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RestTemplateVO> rest2(@PathVariable("id") String id) {
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		ResponseEntity<RestTemplateVO> response = new ResponseEntity<RestTemplateVO>(restTemplateVO,HttpStatus.OK);
		return response;
	}
	
	
	
	
}
