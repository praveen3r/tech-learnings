package com.demo.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Cacheable(value="customer")
	public String getData() {
		System.out.println("coming to method execution");
		return "test";
	}
}
