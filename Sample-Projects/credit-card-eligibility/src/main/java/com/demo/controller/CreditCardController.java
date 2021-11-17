package com.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.UserCredit;
import com.demo.service.CreditDataService;

@Controller
public class CreditCardController {

	@Autowired
	CreditDataService panCardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/checkEligibility", method = RequestMethod.POST)
	public String validatePan(UserCredit userCredit, Model model) {
		return panCardService.validateCreditScore(userCredit);
	}
}
