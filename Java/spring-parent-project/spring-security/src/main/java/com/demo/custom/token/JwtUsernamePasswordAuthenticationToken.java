package com.demo.custom.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.SpringSecurityCoreVersion;

public class JwtUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	private String token;
	
	public JwtUsernamePasswordAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	
}
