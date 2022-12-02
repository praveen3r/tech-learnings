package com.demo.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AuthValidationService {
	
	public void validateAuth(@NotBlank @Size(min = 4)String principal, @NotBlank @Size(min = 1) String credentials){
		
	}
}
