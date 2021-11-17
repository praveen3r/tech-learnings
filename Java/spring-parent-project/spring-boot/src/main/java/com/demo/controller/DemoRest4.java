package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySources({ @PropertySource(value = "classpath:demo.properties", ignoreResourceNotFound = true),
	@PropertySource(value = "classpath:demo-${spring.profiles.active}.properties", ignoreResourceNotFound = true) })
public class DemoRest4 {

	@Value("${demo.text}")
	private String demoText;

	@RequestMapping(method=RequestMethod.GET,value="/test44")
	public String test() {
		System.out.println(demoText);
		return demoText;
	}
}
