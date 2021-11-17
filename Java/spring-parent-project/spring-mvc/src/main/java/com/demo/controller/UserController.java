package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.dto.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	//http://localhost:8080/spring-mvc/user/home
	/*@RequestMapping(method = RequestMethod.GET, value="/home")
    public String userHome(@ModelAttribute("userVO") UserVO userVO) {
        return "user/user";
    }*/
	
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public String userHome(Model model) {
		UserVO userVO = new UserVO();
		userVO.setFirstName("Raghu");
		model.addAttribute("userVO", userVO);
        return "user/user";
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
    public String addUser(@ModelAttribute("userVO") UserVO userVO, Model model) {
		System.out.println("fistname " + userVO.getFirstName() + " lastname " + userVO.getLastName() 
							+ " email " + userVO.getEmailId()  + " address " + userVO.getAddress());
		model.addAttribute("msg", "User created Successfully");
		return "user/user";
    }
}
