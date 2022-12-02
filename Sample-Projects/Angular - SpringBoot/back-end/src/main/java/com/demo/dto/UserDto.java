package com.demo.dto;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public UserDto(BigInteger id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	
	
	
	

}
