package com.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dto.JsonAddressVO;
import com.demo.dto.JsonVO;
import com.demo.dto.JsonVO1;
import com.demo.dto.JsonVO2;
import com.demo.dto.JsonVO3;
import com.demo.dto.Views;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Controller
@RequestMapping("/test1/")
public class TestJsonController {

	//http://localhost:8080/spring-mvc/test1/rest1
	@ResponseBody
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public ResponseEntity<String> rest1() {
		ResponseEntity<String> response = new ResponseEntity<String>("demo",HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public ResultEntity<String> rest2() {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public ResponseEntity<JsonVO> rest3() {
		JsonVO jsonVO = new JsonVO();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		ResponseEntity<JsonVO> response = new ResponseEntity<JsonVO>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public ResponseEntity<JsonVO1> rest4() {
		JsonVO1 jsonVO = new JsonVO1();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		ResponseEntity<JsonVO1> response = new ResponseEntity<JsonVO1>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest5", method = RequestMethod.GET)
	public ResponseEntity<JsonVO2> rest5() {
		JsonVO2 jsonVO = new JsonVO2();
		JsonAddressVO jsonAddressVO = new JsonAddressVO();
		jsonAddressVO.setAddrLine1("line1");
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		jsonVO.setAddress(jsonAddressVO);
		ResponseEntity<JsonVO2> response = new ResponseEntity<JsonVO2>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest6", method = RequestMethod.GET)
	public ResponseEntity<String> rest6() throws Exception{
		JsonVO3 jsonVO = new JsonVO3();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		ObjectMapper mapper = new ObjectMapper();
	    String result = mapper
	      .writerWithView(Views.Public.class)
	      .writeValueAsString(jsonVO);
		ResponseEntity<String> response = new ResponseEntity<String>(result,HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest7", method = RequestMethod.GET)
	public ResponseEntity<JsonVO3> rest7() throws Exception{
		JsonVO3 jsonVO = new JsonVO3();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		ResponseEntity<JsonVO3> response = new ResponseEntity<JsonVO3>(jsonVO,HttpStatus.OK);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "rest8", method = RequestMethod.GET)
	public ResponseEntity<String> rest8() throws Exception{
		JsonVO3 jsonVO = new JsonVO3();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("FIINS");
		FilterProvider filterProvider = new SimpleFilterProvider().
		          addFilter("customFilter",
		                  SimpleBeanPropertyFilter.filterOutAllExcept("name"));
		ObjectMapper mapper = new ObjectMapper();
	    String result = mapper
	    		.writer(filterProvider)
	      .writeValueAsString(jsonVO);
		ResponseEntity<String> response = new ResponseEntity<String>(result,HttpStatus.OK);
		return response;
	}
}
