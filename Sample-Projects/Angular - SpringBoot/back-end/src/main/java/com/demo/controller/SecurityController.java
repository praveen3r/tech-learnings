package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.SecurityService;

@RestController
@RequestMapping(value = "/v1/sec/")
public class SecurityController {
	
	@Autowired
	SecurityService securityService;

	/*@GetMapping(value = {"key", "key/{id}" })
	public String getSecretKey(@PathVariable final Optional<String> id, Principal principal) throws Exception{
		String idNew = null;
		if(id.isPresent())
			idNew = id.get().toUpperCase();
		else
			idNew = principal.getName();
		final String key = securityService.generateSecretKey(idNew);
		return key;
	}*/
	
	@GetMapping(value = {"key"})
	public String getSecretKey() throws Exception{
		
		final String key = securityService.generateSecretKey();
		return key;
	}
	
}
