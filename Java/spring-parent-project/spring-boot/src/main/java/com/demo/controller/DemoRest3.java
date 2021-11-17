package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("config.properties")
public class DemoRest3 {
	
	@Value("${db.url}")
	private String dbUrl;

	@RequestMapping(method=RequestMethod.GET,value="/test3")
	public String test() {
		System.out.println(dbUrl);
		return "test3";
	}
}
