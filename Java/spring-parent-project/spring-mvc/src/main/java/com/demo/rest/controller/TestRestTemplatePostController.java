package com.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.dto.RestTemplateVO;

@RestController
@RequestMapping("/restTemplate2")
public class TestRestTemplatePostController {

	//http://localhost:8080/spring-mvc/restTemplate2/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.POST)
	public ResponseEntity<Void> rest1(@RequestBody RestTemplateVO restTemplateVO) {
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.POST)
	public ResponseEntity<String> rest2(@RequestBody RestTemplateVO restTemplateVO) {
		ResponseEntity<String> response = new ResponseEntity<String>(restTemplateVO.getId(),HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.POST)
	public ResponseEntity<RestTemplateVO> rest3(@RequestBody RestTemplateVO restTemplateVO) {
		ResponseEntity<RestTemplateVO> response = new ResponseEntity<RestTemplateVO>(restTemplateVO,HttpStatus.OK);
		return response;
	}
	
	//Form data application/x-www-form-urlencoded
	@RequestMapping(value = "rest4", method = RequestMethod.POST)
	public ResponseEntity<String> rest4(@RequestParam("id") String id) {
		ResponseEntity<String> response = new ResponseEntity<String>("Success",HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.POST)
	public ResponseEntity<String> rest5(@RequestParam final MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		ResponseEntity<String> response = new ResponseEntity<String>("Success",HttpStatus.OK);
		return response;
	}
}
