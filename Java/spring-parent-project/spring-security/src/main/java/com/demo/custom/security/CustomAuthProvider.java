package com.demo.custom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.demo.service.CustomAuthService;

@Component
public class CustomAuthProvider implements AuthenticationProvider{

	@Autowired
	CustomAuthService customAuthService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return customAuthService.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
