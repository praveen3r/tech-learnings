package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/locale")
public class LocaleController {

	//http://localhost:8080/spring-mvc/locale/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public String localeHome() {
        return "locale/home";
    }
	
}
