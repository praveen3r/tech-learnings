package com.demo.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.demo.dto.AuthResponseDto;
import com.demo.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
    	
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    	final var errorCode = exception.getMessage();
		final var	errorCodeOpt = Optional.ofNullable(errorCode);
    	if(errorCodeOpt.isPresent()){
    		if(CommonUtil.compareValues(errorCode, "2"))
    			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //Not valid credentials
    		else
    			response.setStatus(424); //Error while processing
    	}
    	try(PrintWriter out = response.getWriter()){
			var authResponseDto = new AuthResponseDto();
			authResponseDto.setSuccess(false);
			var responseVal = objectMapper.writeValueAsString(authResponseDto);
			out.print(responseVal);
			out.flush();
    	}
    }
}
