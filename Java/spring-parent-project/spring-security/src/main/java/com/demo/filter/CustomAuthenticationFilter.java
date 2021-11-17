package com.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.custom.token.CustomUsernamePasswordAuthenticationToken;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		UsernamePasswordAuthenticationToken token = getAuthRequest(request);

		setDetails(request, token);

		return this.getAuthenticationManager().authenticate(token);
	}

	private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String corpId = request.getParameter("corpId");

		return new CustomUsernamePasswordAuthenticationToken(username, password, corpId);
	}
}
