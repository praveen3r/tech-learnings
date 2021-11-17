package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class CustomAuthService {
	
	@Autowired
	UserRepository userRepository;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		
		System.out.println(authentication.getPrincipal());
		
		User user = userRepository.findOne(new BigInteger("1"));
		
		return new UsernamePasswordAuthenticationToken("123", "", null);
	}
}
