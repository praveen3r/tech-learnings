package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

@Service
public class MethodSecurityService {

	@PreFilter("filterObject != authentication.principal")
	public String addUser(List<String> usernames) {
	    return usernames.stream().collect(Collectors.joining(";"));
	}
	
	@PostFilter("filterObject == authentication.principal")
	public List<String> getUser(){
		List<String> usersList = new ArrayList<String>();
		usersList.add("123");
		usersList.add("1234");
		return usersList;
	}
}
