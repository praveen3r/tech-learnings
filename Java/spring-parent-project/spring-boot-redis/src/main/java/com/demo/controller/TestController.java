package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

	@RequestMapping(value = "1", method = RequestMethod.GET)
	public String getVersion() {
		return "hello world";
	}
}
