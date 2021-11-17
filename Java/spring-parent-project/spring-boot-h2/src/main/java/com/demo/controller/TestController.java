package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

@RestController
@RequestMapping("/test/")
public class TestController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "1", method = RequestMethod.GET)
	public String getVersion() {
		userService.insertData();
		return "hello world";
	}
}
