package com.demo.rest.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reqHeader/")
public class RequestHeaderController {

	@RequestMapping("/displayHeaderInfo")
	public String displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
	                              @RequestHeader(value="Keep-Alive",required=false) Long keepAlive)  {

		return encoding;
	}
}
