package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.custom.validation.UserValidationVO1Validator;
import com.demo.dto.UserValidationVO;
import com.demo.dto.UserValidationVO1;

@Controller
@RequestMapping("/userValidation1")
public class UserValidationController1 {

	@Autowired
	UserValidationVO1Validator validator;
	
	//http://localhost:8080/spring-mvc/userValidation1/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() {
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		modelAndView.addObject("userVO", new UserValidationVO1());
		return modelAndView;
    }
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public ModelAndView addUser(@Valid @ModelAttribute("userVO") UserValidationVO1 userVO, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		if(result.hasErrors()){
			return modelAndView;
		}
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" ph no " + userVO.getPhoneNo());
		modelAndView.addObject("msg", "User created Successfully");
		return modelAndView;
    }*/
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public ModelAndView addUser(@Valid @ModelAttribute("userVO") UserValidationVO1 userVO, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		if(result.hasErrors()){
			return modelAndView;
		}
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" ph no " + userVO.getPhoneNo());
		modelAndView.addObject("msg", "User created Successfully");
		return modelAndView;
    }*/
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
    public ModelAndView addUser(@Valid @ModelAttribute("userVO") UserValidationVO1 userVO, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("user/userValidation1");
		validator.validate(userVO, result);
		if(result.hasErrors()){
			return modelAndView;
		}
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" ph no " + userVO.getPhoneNo());
		modelAndView.addObject("msg", "User created Successfully");
		return modelAndView;
    }
	
}
