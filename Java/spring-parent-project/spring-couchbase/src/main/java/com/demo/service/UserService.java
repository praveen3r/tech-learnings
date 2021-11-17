package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	CustomerService customerService;
	
	public String getData() {
		return customerService.getData();
	}
}
