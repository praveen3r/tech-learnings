package com.demo.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.MultipleContentVO;
import com.demo.editor.CustomNameEditor;

@RestController
@RequestMapping("/mulContent/")
public class MultipleContentController {

	//http://localhost:8080/spring-mvc/mulContent/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	//@RequestMapping(value = "rest1", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public MultipleContentVO rest1() {
		MultipleContentVO jsonVO = new MultipleContentVO();
		jsonVO.setId("1");
		jsonVO.setName("Test");
		jsonVO.setDept("clerk");
		return jsonVO;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.POST)
	//@RequestMapping(value = "rest2", method = RequestMethod.POST, consumes=MediaType.APPLICATION_XML_VALUE)
	public MultipleContentVO rest2(@RequestBody MultipleContentVO multipleContentVO) {
		return multipleContentVO;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.POST)
	//@RequestMapping(value = "rest2", method = RequestMethod.POST, consumes=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<MultipleContentVO> rest3(@RequestBody MultipleContentVO multipleContentVO) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("test", "testVal");
		ResponseEntity<MultipleContentVO> responseEntity = new ResponseEntity<MultipleContentVO>(multipleContentVO, headers , HttpStatus.OK);
		return responseEntity;
	}
	
	@InitBinder
	public void initBind(WebDataBinder binder){
		binder.setDisallowedFields(new String[]{"id"});
	}
}
