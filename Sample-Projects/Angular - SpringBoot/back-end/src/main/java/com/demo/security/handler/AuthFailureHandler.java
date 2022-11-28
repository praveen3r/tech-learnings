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
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
    	
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    	final String errorCode = exception.getMessage();
		final Optional<String>	errorCodeOpt = Optional.ofNullable(errorCode);
    	if(errorCodeOpt.isPresent()){
    		if(errorCode.equals("2"))
    			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //Not valid credentials
    		else if(errorCode.equals("3"))
    			response.setStatus(423);  //Lock the user
    		else if(errorCode.equals("4"))
    			response.setStatus(420);  //Inactive user
    		else if(errorCode.equals("8"))
    			response.setStatus(424); //Error while processing
    		else
    			response.setStatus(424); //Error while processing
    	}
    	try(PrintWriter out = response.getWriter()){
			AuthResponseDto authResponseDto = new AuthResponseDto();
			authResponseDto.setSuccess(false);
			String responseVal = objectMapper.writeValueAsString(authResponseDto);
			out.print(responseVal);
			out.flush();
    	}
    }
}
