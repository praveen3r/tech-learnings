package com.demo.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.demo.dto.AuthResponseDto;
import com.demo.security.token.TokenManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	TokenManager tokenManager;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
    	response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_OK);
		try(PrintWriter out = response.getWriter()){
			var token = tokenManager.createToken(authentication);
			var authResponseDto = new AuthResponseDto();
			authResponseDto.setSuccess(Boolean.TRUE);
			authResponseDto.setToken(token);
			var responseVal = objectMapper.writeValueAsString(authResponseDto);
			out.print(responseVal);
			out.flush();
		}
    }
}
