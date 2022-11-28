/**
 * 
 */
package com.demo.security.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.demo.dto.AuthResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		try(PrintWriter out = response.getWriter()){
			AuthResponseDto authResponseDto = new AuthResponseDto();
			authResponseDto.setSuccess(false);
			String responseVal = objectMapper.writeValueAsString(authResponseDto);
			out.print(responseVal);
			out.flush();
    	}
	}
}
