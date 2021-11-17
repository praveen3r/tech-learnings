package com.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserExternalService {
	
	private final RestTemplate restTemplate;

	public UserExternalService() {
		this.restTemplate = new RestTemplate();
	}

	public String callExternal() {
        return restTemplate.getForObject("http://localhost:8080/test23", String.class);
    }

}
