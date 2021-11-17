package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest1 {
	
	@Value("${test.value}")
	String testVal;
	
	@Value("${server.port}")
	int port;

	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String test() {
		//return "test1";
		System.out.println(port);
		return testVal;
	}
}
