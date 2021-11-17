/**
 * 
 */
package com.demo.custom.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @author e1001266
 *
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = -7798833523552714201L;
	private final String corpId;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		corpId = request.getParameter("corpId");
	}

	public String getCorpId() {
		return corpId;
	}
	
	
	
}
