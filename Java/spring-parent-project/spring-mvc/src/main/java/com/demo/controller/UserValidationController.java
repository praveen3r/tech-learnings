package com.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dto.UserValidationVO;
import com.demo.dto.UserValidationVO1;

@Controller
@RequestMapping("/userValidation")
public class UserValidationController {

	//http://localhost:8080/spring-mvc/userValidation/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() {
		ModelAndView modelAndView = new ModelAndView("user/userValidation");
		modelAndView.addObject("userVO", new UserValidationVO());
		return modelAndView;
    }
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public String addUser(@ModelAttribute("userVO") UserValidationVO userVO, Model model) {
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		model.addAttribute("msg", "User created Successfully");
		return "user/userValidation";
    }*/
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
    public ModelAndView addUser(@Valid @ModelAttribute("userVO") UserValidationVO userVO, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("user/userValidation");
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
