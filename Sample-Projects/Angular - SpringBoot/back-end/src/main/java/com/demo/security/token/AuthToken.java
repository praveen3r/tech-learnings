package com.demo.security.token;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigInteger userId;
	
}
