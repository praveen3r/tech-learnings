package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

		//http://localhost:8080/spring-security/
		@RequestMapping(method = RequestMethod.GET, value="/")
	    public String defaultHome() {
			return "home";
	    }
		
		@RequestMapping(method = RequestMethod.GET, value="/home")
	    public String home() {
			return "home";
	    }
		
		@RequestMapping(method = RequestMethod.GET, value="/home1")
	    public String home11() {
			return "home";
	    }
		
		@RequestMapping(method = RequestMethod.GET, value="/login")
	    public String login() {
			return "login";
	    }
		
		/*@RequestMapping(method = RequestMethod.POST, value="/login")
	    public String login1() {
			return "home";
	    }*/
		
		@RequestMapping(method = RequestMethod.POST, value="/loginProcess")
	    public void loginProcess() {
			System.out.println("123");
	    }
		
		/*@RequestMapping(method = RequestMethod.POST, value="/loginProcess")
	    public String loginProcess() {
			return "home";
	    }*/
		
		@RequestMapping(method = RequestMethod.GET, value="/loginProcess")
		public String loginProcess1() {
			return "home";
	    }
		
		@RequestMapping(method = RequestMethod.GET, value="/logout")
	    public String logout(HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
			return "login";
	    }
}
