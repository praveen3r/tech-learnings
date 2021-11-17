package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalizationDemo {

	@Autowired
	MessageBundle messageBundle;
	
	//http://localhost:8082/testinter?localeId=en&msg=hello
	@RequestMapping(method=RequestMethod.GET,value="/testinter")
	public String test(@RequestParam("localeId") String localeId,
						@RequestParam("msg") String msg) {
		return messageBundle.getMsg(msg, localeId);
	}
}
