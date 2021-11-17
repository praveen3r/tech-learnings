package com.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import com.demo.service.FluxService;

@RestController
@RequestMapping("/fluxtest/")
public class FluxTestController {
	
	
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public Flux<String> rest2() {
		Flux<String> flux = Flux.just("Test1","Test2","Test3","Test4")
				.delayElements(Duration.ofSeconds(1));
		return flux;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET, produces= MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> rest1() {
		return Flux.interval(Duration.ofSeconds(1)).log();
	}

}
