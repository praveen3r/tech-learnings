package com.demo.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/monotest/")
public class MonoTestController {
	
	
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public Mono<String> rest2() {
		Mono<String> mono = Mono.just("Test1");
		return mono;
	}
	
	

}
