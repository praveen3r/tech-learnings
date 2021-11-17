package com.demo.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.MethodSecurityService;

@RestController
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	MethodSecurityService methodSecurityService;

	//http://localhost:8080/spring-security/test/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public String rest1() {
		return "hello world";
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public String rest2(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails.getUsername());
		return "hello world";
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public String rest3() {
		return "hello world";
	}
	
	@RequestMapping(value = "rest4/{username}", method = RequestMethod.GET)
	@PreAuthorize("#username == authentication.principal")
	public String rest4(@PathVariable("username") String username) {
		return "hello world";
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.GET)
	@PostAuthorize("returnObject == authentication.principal")
	public String rest5() {
		return "123";
	}
	
	@RequestMapping(value = "rest6", method = RequestMethod.GET)
	@Secured("ROLE_USER")
	public String rest6() {
		return "hello world";
	}
	
	@RequestMapping(value = "rest7", method = RequestMethod.GET)
	@RolesAllowed({ "ROLE_USER", "ROLE_ADMIN" })
	public String rest7() {
		return "hello world";
	}
	
	@RequestMapping(value = "rest8", method = RequestMethod.GET)
	public String rest8() {
		List<String> usersList = new ArrayList<String>();
		usersList.add("123");
		usersList.add("1234");
	    return methodSecurityService.addUser(usersList);
	}
	
	@RequestMapping(value = "rest9", method = RequestMethod.GET)
	public List<String> rest9() {
	    return methodSecurityService.getUser();
	}
}
