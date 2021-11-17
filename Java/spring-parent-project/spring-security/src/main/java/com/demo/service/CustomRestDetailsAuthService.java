package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.demo.custom.security.CustomWebAuthenticationDetails;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class CustomRestDetailsAuthService {
	
	@Autowired
	UserRepository userRepository;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		
		System.out.println(authentication.getPrincipal());
		
		String corpId = "";
		if(authentication.getDetails() instanceof CustomWebAuthenticationDetails){
			CustomWebAuthenticationDetails cibWebAuthenticationDetails = (CustomWebAuthenticationDetails)authentication.getDetails();
			corpId = cibWebAuthenticationDetails.getCorpId();
		}
		
		System.out.println(corpId);
		
		User user = userRepository.findOne(new BigInteger("1"));
		
		return new UsernamePasswordAuthenticationToken("123", "", null);
	}
}
