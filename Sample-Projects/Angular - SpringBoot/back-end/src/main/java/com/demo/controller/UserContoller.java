package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

@RestController
@RequestMapping(value = "/v1/users/")
public class UserContoller {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = {RequestMethod.GET})
	public String getUsers() throws Exception{
		return userService.getUsers();
	}
}
