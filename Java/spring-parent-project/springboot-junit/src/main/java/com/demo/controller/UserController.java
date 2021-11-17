package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

@RestController(value="/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/test23")
	public String getUsers(){
		userService.getData();
		return "test";
	}
}
