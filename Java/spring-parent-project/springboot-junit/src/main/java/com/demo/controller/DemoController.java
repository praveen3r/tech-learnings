package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;

	@RequestMapping(method=RequestMethod.GET,value="/test")
	public String test() {
		return demoService.test();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/test1")
	public String test1() {
		return "test1";
	}
}
