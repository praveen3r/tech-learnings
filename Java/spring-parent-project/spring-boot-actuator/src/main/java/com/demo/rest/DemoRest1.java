package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CustomMetric;

@RestController
public class DemoRest1 {
	
    @Autowired
    CustomMetric customMetric;
    
	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test1")
	public String test1() {
		customMetric.display();
		return "test1";
	}
}
