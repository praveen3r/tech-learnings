/**
 *
 */
package com.demo.security.token;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.demo.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenManager {

	@Autowired
	TokenService tokenService;
	
	public String createToken(Authentication authentication) {
		var userId = (BigInteger)authentication.getPrincipal();
		var authToken = new AuthToken();
		authToken.setUserId(userId);
		var token = tokenService.createToken(userId.toString(), authToken);
		
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
			if (CommonUtil.isNotEmpty(authtoken)) {
				var userId = authtoken.getUserId();
				var key = userId.toString();
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
