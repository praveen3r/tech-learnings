package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest1 {

	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String test() {
		return "test1";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test1")
	public String test1() {
		return "test1";
	}
}
