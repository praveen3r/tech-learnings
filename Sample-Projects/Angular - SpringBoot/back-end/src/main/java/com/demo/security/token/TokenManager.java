/**
 *
 */
package com.demo.security.token;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenManager {

	@Autowired
	TokenService tokenService;
	
	public String createToken(String key, Authentication authentication) {
		BigInteger userId = (BigInteger)authentication.getPrincipal();
		AuthToken authToken = new AuthToken();
		authToken.setUserId(userId);
		String token = tokenService.createToken(key, authToken);
		
		tokenService.storeToken(userId.toString(), token);
		return token;
	}
	
	public void updateToken(String key, String token) {
		tokenService.storeToken(key, token);
	}

	public AuthToken validateAndBuild(String token, String tokenWithoutExpiration) {
		AuthToken authtoken = null;
		try{
			authtoken = tokenService.buildAuthentication(tokenWithoutExpiration);
			if (authtoken != null) {
				BigInteger userId = authtoken.getUserId();
				String key = userId.toString();
				if (!tokenService.validate(key, token)) {
					log.warn("Possible case of token hijacked for user {}", key);
					authtoken = null;
				}
			}
		}catch(Exception e) {
			log.error("Error while validating and building token due to {}", e.toString());
		}
		return authtoken;
	}

	public void invalidateToken(String key) {
		tokenService.clearToken(key);
	}

}
