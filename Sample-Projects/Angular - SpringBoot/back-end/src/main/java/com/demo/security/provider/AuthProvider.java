package com.demo.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.demo.service.AuthService;

@Component
public class AuthProvider implements AuthenticationProvider{
	
	@Autowired
	AuthService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authService.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
