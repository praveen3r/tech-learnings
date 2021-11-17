package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.custom.validation.UserValidationVO1Validator;

@Controller
@RequestMapping("/exp1")
public class ExceptionController1 {

	@Autowired
	UserValidationVO1Validator validator;
	
	//http://localhost:8080/spring-mvc/exp1/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() throws Exception{
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		System.out.println(1/0);
		return modelAndView;
    }
	
}
