package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.demo.custom.token.CustomUsernamePasswordAuthenticationToken;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class CustomRestAuthService {
	
	@Autowired
	UserRepository userRepository;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		CustomUsernamePasswordAuthenticationToken customUsernamePasswordAuthenticationToken = (CustomUsernamePasswordAuthenticationToken)authentication;
		
		System.out.println(customUsernamePasswordAuthenticationToken.getPrincipal());
		System.out.println(customUsernamePasswordAuthenticationToken.getCorpId());
		
		User user = userRepository.findOne(new BigInteger("1"));
		
		return new UsernamePasswordAuthenticationToken("123", "", null);
	}
}
