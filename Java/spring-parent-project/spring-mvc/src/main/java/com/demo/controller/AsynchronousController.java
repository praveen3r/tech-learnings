package com.demo.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/async")
public class AsynchronousController {

	@RequestMapping(method = RequestMethod.GET, value="/home")
    public Callable<String> userHome() {
		return new Callable<String>() {
			public String call() throws Exception {
		      return "demo";
		    } 
		};
	}
}
