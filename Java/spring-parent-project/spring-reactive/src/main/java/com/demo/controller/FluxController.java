/*package com.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import com.demo.service.FluxService;

@RestController
@RequestMapping("/flux/")
public class FluxController {
	
	@Autowired
	FluxService fluxService;
	
	//@RequestMapping(value = "rest1", method = RequestMethod.GET)
	@RequestMapping(value = "rest1", method = RequestMethod.GET, produces= MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> rest1() {
		Flux<String> flux = fluxService.getData();
		return flux;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET, produces= MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> rest1() {
		Flux<Long> flux = fluxService.runWithInfiteLoop();
		return flux;
	}
	
}
*/