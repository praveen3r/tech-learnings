package com.demo.dto;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AuthDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	
	private String userName;
	
	private String credential;
	
}
