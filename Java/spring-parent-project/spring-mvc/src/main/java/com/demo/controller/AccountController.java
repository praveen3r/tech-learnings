package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dto.AccountVO;

@Controller
@RequestMapping("/account")
public class AccountController {

	//http://localhost:8080/spring-mvc/account/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView accountHome() {
		return new ModelAndView("account/create", "accountVO", new AccountVO());
    }
	
	@RequestMapping(method = RequestMethod.POST, value={"/home", "/add"})
    public String accountAdd(@ModelAttribute("accountVO") AccountVO accountVO, Model model) {
		System.out.println("AccountNo " + accountVO.getAccountNo());
		accountVO.clearValues();
		model.addAttribute("success", "true");
		return "account/create";
    }
	
	
}
