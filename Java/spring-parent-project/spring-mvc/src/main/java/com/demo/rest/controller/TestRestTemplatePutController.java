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
@RequestMapping("/restTemplate3")
public class TestRestTemplatePutController {

	@RequestMapping(value = "rest1/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RestTemplateVO> rest3(@PathVariable("id") String id, @RequestBody RestTemplateVO restTemplateVO) {
		ResponseEntity<RestTemplateVO> response = new ResponseEntity<RestTemplateVO>(restTemplateVO,HttpStatus.OK);
		return response;
	}
	
	
	
	
}
