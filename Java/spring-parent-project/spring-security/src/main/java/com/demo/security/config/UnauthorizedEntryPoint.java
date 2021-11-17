/**
 * 
 */
package com.demo.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author e1001266
 *
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	private static final String UNAUTHORIZED_JSON = "{\"message\":\"Full authentication is required to access this resource.\", \"access-denied\":true,\"cause\":\"NOT AUTHENTICATED\"}";

	/**
	 * Always returns a 401 error code to the client.
	 */
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		PrintWriter out = response.getWriter();
		out.print(UNAUTHORIZED_JSON);
		out.flush();
		out.close();
	}
}
