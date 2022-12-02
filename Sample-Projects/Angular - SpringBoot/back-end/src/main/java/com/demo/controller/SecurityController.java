package com.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.SecurityService;

@RestController
@RequestMapping(value = "/v1/sec/")
public class SecurityController {
	
	@Autowired
	SecurityService securityService;

	@GetMapping(value = {"key/{id}" })
	public String getSecretKey(@PathVariable final String id, Principal principal) throws Exception{
		final String key = securityService.generateSecretKey(id);
		return key;
	}
	
	
	
}
