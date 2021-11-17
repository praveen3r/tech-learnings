package com.demo.custom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.demo.custom.token.JwtUsernamePasswordAuthenticationToken;
import com.demo.service.JwtAuthService;

@Component
public class JwtAuthProvider implements AuthenticationProvider{

	@Autowired
	JwtAuthService jwtAuthService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return jwtAuthService.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(JwtUsernamePasswordAuthenticationToken.class);
	}

}
