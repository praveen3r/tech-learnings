package com.demo.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/rest")
//localhost:8080/swagger-ui.html
@Api(value = "Rest Controller")
public class DemoRestController {

	
	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test1")
	public String test1(@ApiParam(value = "sample data") @RequestParam("test") String test1) {
		return "test1";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test12")
	public String test12(@ApiParam(value = "sample data1") @RequestParam("test1") String test1, @ApiParam(value = "sample data2") @RequestParam("test2") String test2) {
		return "test12";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test123")
	public String test123(@ApiParam(value = "sample data1") @RequestParam("test1") String test1, @ApiParam(hidden=true, access = "hide") @RequestParam("test2") String test2) {
		return "test123";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test1234")
	public String test1234(@ApiParam(value = "sample data1") @RequestParam("test1") String test1, @ApiIgnore Authentication authentication1) {
		return "test1234";
	}
	
	@ApiOperation(value = "Test Method",response = String.class)
	@RequestMapping(method=RequestMethod.POST,value="/test2")
	public String test2(@RequestBody final String data) {
		return "test2";
	}
	
	@ApiOperation(value = "Test Method",produces = "application/json")
	@RequestMapping(method=RequestMethod.POST,value="/test3")
	public ResponseEntity<String> test3(@RequestBody final String data) {
		return new ResponseEntity<String>("test3",HttpStatus.OK);
	}
	
	
}
