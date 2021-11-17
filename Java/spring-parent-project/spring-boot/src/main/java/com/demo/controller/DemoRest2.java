package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.config.DemoConfig;

@RestController
public class DemoRest2 {
	
	@Autowired
	DemoConfig demoConfig;

	@RequestMapping(method=RequestMethod.GET,value="/test2")
	public String test() {
		System.out.println(demoConfig.getServers());
		System.out.println(demoConfig.getTestStr());
		return "test2";
	}
}
