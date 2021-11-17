package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.custom.validation.UserValidationVO1Validator;

@Controller
@RequestMapping("/exp")
public class ExceptionController {

	@Autowired
	UserValidationVO1Validator validator;
	
	//http://localhost:8080/spring-mvc/exp/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() throws Exception{
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		System.out.println(1/0);
		return modelAndView;
    }
	
	/*@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHomeWithTryCath() throws Exception{
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
    }*/
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String handleArithmeticException(Exception e){
		System.out.println("coming to handleArithmeticException");
		return "error/error";
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e){
		System.out.println("coming to handleException");
		return "error/error";
		
	}
	
	
	
}
