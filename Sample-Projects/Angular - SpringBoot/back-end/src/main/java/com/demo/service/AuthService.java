package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.repository.AuthRepository;


@Service
public class AuthService {

	@Autowired
	AuthRepository authRepository;
	
	@Autowired
	AuthValidationService authValidationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authenticationNew = null;
		var userName = authentication.getPrincipal().toString();
		var encKeyWord = authentication.getCredentials().toString();
		encKeyWord = encKeyWord.replaceAll("AB1", "+");
		try {	
			var plainCredential = securityService.getPlainKeyWord(userName, encKeyWord);
			authValidationService.validateAuth(userName, plainCredential);
			securityService.clearSecretKey(userName);
			var hashedCredential = securityService.getHashedCredential(plainCredential);
			var responseCode = authRepository.authenticate(userName, hashedCredential);
			if (responseCode == 1) {
				var userId = userService.getUserId(userName);
				authenticationNew = new UsernamePasswordAuthenticationToken(userId, null, null);
			}
			else if (responseCode == 2)
				throw new UsernameNotFoundException(responseCode.toString());
		} catch (AuthenticationException ex) {
			throw new InternalAuthenticationServiceException(ex.getMessage());
		} catch (Exception e) {
			throw new InternalAuthenticationServiceException("8");
		}
		return authenticationNew;
	}
	
	
}
