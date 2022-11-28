package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AuthResponseDto {

	private Boolean success;
	
	private String token;
	
	//private UserDto user;
	
}
