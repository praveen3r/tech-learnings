package com.demo.security.handler;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.demo.security.token.TokenManager;
import com.demo.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthLogOutHandler implements LogoutSuccessHandler {

	@Autowired
	TokenManager tokenManager;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (CommonUtil.isNotEmpty(authentication) && CommonUtil.isNotEmpty(authentication.getPrincipal())) {
			var userId = (BigInteger)authentication.getPrincipal();
			tokenManager.invalidateToken(userId.toString());
		}else {
			log.error("Unable to locate the principal");
		}
			
		
	}

}
