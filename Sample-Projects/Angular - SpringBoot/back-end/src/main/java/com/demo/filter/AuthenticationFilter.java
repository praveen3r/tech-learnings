package com.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.dto.HeaderDto;
import com.demo.security.token.TokenManager;
import com.demo.util.CommonUtil;
import com.demo.util.Constants;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

	TokenManager tokenManager;
	
	String expiryKey;
	
	Long expiryTime;
	
	protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain) throws ServletException, IOException {
    
    	final HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = null;
		String jwtToken = null;
		if (CommonUtil.isNotEmpty(httpRequest.getHeader(Constants.AUTH_HEADER))) {
			token = httpRequest.getHeader(Constants.AUTH_HEADER);
			jwtToken = token.replaceAll(Constants.BEARER_VAL, "");
		} 
		
		var securityContext = SecurityContextHolder.createEmptyContext();
		securityContext = new SecurityContextImpl();
		if (StringUtils.isNotEmpty(token)) {
			if (CommonUtil.isNotEmpty(jwtToken)) {
				var tokenExpArr = jwtToken.split(expiryKey);
				var tokenExpirationValue = tokenExpArr[1];
				var tokenExpiration = Long.parseLong(tokenExpirationValue);
				var tokenWithoutExpiration = tokenExpArr[0];
				final var authToken = tokenManager.validateAndBuild(jwtToken, tokenWithoutExpiration);
				if (CommonUtil.isNotEmpty(authToken)) {
					if (System.currentTimeMillis() < tokenExpiration) {
						final var sb = new StringBuilder();
						sb.append(jwtToken).append(expiryKey);
						var milliSecs = System.currentTimeMillis() + (expiryTime * 1000);
						sb.append(milliSecs);
						tokenManager.updateToken(authToken.getUserId().toString(), sb.toString());
						final var headerDto = HeaderDto.builder().userId(authToken.getUserId()).authorization(jwtToken).build();
						final var upt = new UsernamePasswordAuthenticationToken(authToken.getUserId(), "", null);
						upt.setDetails(headerDto);
						securityContext.setAuthentication(upt);
					} else {
						tokenManager.invalidateToken(authToken.getUserId().toString());
						log.warn("Expired token for user {}", authToken.getUserId());
					}
				}
			} 
		}
		
		try {
			SecurityContextHolder.setContext(securityContext);
			filterChain.doFilter(request, response);
		} finally {
			SecurityContextHolder.clearContext();
		}
    
    }
}