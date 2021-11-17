package com.demo.rest.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dto.AnyGetterVO;
import com.demo.dto.JavaToJson;

@Controller
@ResponseBody
@RequestMapping("/javaToJson/")
public class JavaToJsonController {

	//http://localhost:8080/spring-mvc/javaToJson/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public ResponseEntity<JavaToJson> rest1() {
		JavaToJson jsonVO = new JavaToJson();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("clerk");
		ResponseEntity<JavaToJson> response = new ResponseEntity<JavaToJson>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public ResponseEntity<JavaToJson> rest2() {
		JavaToJson jsonVO = new JavaToJson();
		jsonVO.setId("1");
		ResponseEntity<JavaToJson> response = new ResponseEntity<JavaToJson>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public ResponseEntity<AnyGetterVO> rest3() {
		AnyGetterVO jsonVO = new AnyGetterVO();
		  Map<String, String > stringMap = jsonVO.getProperties();
		  stringMap.put("emailId","james@gmail.com");
		  stringMap.put("gender","male");
		ResponseEntity<AnyGetterVO> response = new ResponseEntity<AnyGetterVO>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public ResponseEntity<JavaToJson> rest4() {
		JavaToJson jsonVO = new JavaToJson();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("clerk");
		jsonVO.setActiveDate(new Date());
		ResponseEntity<JavaToJson> response = new ResponseEntity<JavaToJson>(jsonVO,HttpStatus.OK);
		return response;
	}
	
}
