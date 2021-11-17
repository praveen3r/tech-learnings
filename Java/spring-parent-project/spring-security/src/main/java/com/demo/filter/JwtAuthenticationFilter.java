package com.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.demo.custom.token.JwtUsernamePasswordAuthenticationToken;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		UsernamePasswordAuthenticationToken token = getAuthRequest(request);

		setDetails(request, token);

		return this.getAuthenticationManager().authenticate(token);
	}

	private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws UsernameNotFoundException{

		//String token = request.getParameter("token");
		String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("token ")) {
        	token = token.substring(6, token.length());
        }else{
        	throw new UsernameNotFoundException("sadf");
        }


		return new JwtUsernamePasswordAuthenticationToken(token);
	}
}
