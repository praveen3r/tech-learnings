package com.demo.rest.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CookieController {

	@RequestMapping("/displayHeaderInfo")
	public String displayHeaderInfo(@CookieValue("JSESSIONID") String cookie)  {
		return cookie;

	}
}
