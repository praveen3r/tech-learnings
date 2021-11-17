package com.demo.custom.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.SpringSecurityCoreVersion;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	private String corpId;
	
	public CustomUsernamePasswordAuthenticationToken(String principal,String credential, String corpId) {
		super(principal, credential);
		this.corpId = corpId;
	}

	public String getCorpId() {
		return corpId;
	}
	
	
}
