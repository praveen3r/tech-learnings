package com.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.custom.token.JwtUsernamePasswordAuthenticationToken;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class JwtAuthService {
	
	@Autowired
	UserRepository userRepository;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		JwtUsernamePasswordAuthenticationToken customUsernamePasswordAuthenticationToken = (JwtUsernamePasswordAuthenticationToken)authentication;
		
		String token = customUsernamePasswordAuthenticationToken.getToken();
		
		Claims claims;
		try {
			claims = getClaims("123",token);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Invalid data");
		}
		
		String username = null;
		String pwd = null;
		
		if(claims != null){
			username = claims.get("username", String.class);
			pwd  = claims.get("pwd", String.class);
		}
		
		System.out.println(username);
		System.out.println(pwd);
		
		User user = userRepository.findOne(new BigInteger("1"));
		
		return new UsernamePasswordAuthenticationToken("123", "", null);
	}
	
	public Claims getClaims(String secret, String token) throws Exception{
		Claims claims = null ;
		
		claims = Jwts.parser()
        .setSigningKey(Base64.encodeBase64(secret.getBytes()))
		.setSigningKey(secret.getBytes())
        .parseClaimsJws(token)
        .getBody();
		
		return claims;
	}
}
