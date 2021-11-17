package com.demo.rest.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AnySetterVO;
import com.demo.dto.JsonCreatorVO;
import com.demo.dto.JsonToJava;
import com.demo.dto.JsonToJavaDeserializer;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/jsonToJava/")
public class JsonToJavaController {

	//http://localhost:8080/spring-mvc/jsonToJava/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.POST)
	public ResponseEntity<Void> rest1(@RequestBody JsonToJava jsonVO) {
		System.out.println(jsonVO.getId());
		System.out.println(jsonVO.getName());
		System.out.println(jsonVO.getDept());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.POST)
	public ResponseEntity<Void> rest2(@RequestBody AnySetterVO anySetterVO) {
		System.out.println(anySetterVO.getProperties());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.POST)
	public ResponseEntity<Void> rest3(@RequestBody JsonCreatorVO jsonCreatorVO) {
		System.out.println(jsonCreatorVO.getId());
		System.out.println(jsonCreatorVO.getName());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.POST)
	public ResponseEntity<Void> rest4(HttpServletRequest request) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		InjectableValues.Std injectableValues = new InjectableValues.Std(); 
		injectableValues.addValue("name","overriden from json");
		mapper.setInjectableValues(injectableValues);
		String value = IOUtils.toString( request.getInputStream());
		JsonToJava jsonVO = mapper.readValue(value, JsonToJava.class);
		System.out.println(jsonVO.getName());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.POST)
	public ResponseEntity<Void> rest3(@RequestBody HashMap<String, String> data) {
		System.out.println(data);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest6", method = RequestMethod.POST)
	public ResponseEntity<Void> rest3(@RequestBody final String data) {
		System.out.println(data);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest7", method = RequestMethod.POST)
	public ResponseEntity<Void> rest5(@RequestBody JsonToJavaDeserializer jsonToJavaDeserializer) throws Exception{
		System.out.println(jsonToJavaDeserializer.getActiveDate());
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
}
