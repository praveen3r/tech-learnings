package com.demo.custom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.demo.custom.token.CustomUsernamePasswordAuthenticationToken;
import com.demo.service.CustomRestAuthService;

@Component
public class CustomRestAuthProvider implements AuthenticationProvider{

	@Autowired
	CustomRestAuthService customAuthService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return customAuthService.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(CustomUsernamePasswordAuthenticationToken.class);
	}

}
