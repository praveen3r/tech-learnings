package com.demo.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxService {

	/*public Flux<String> getData(){
		Flux<String> userFlux = Flux.just("Test1","Test2","Test3","Test4")
								.delayElements(Duration.ofSeconds(1));
		return userFlux;
	}*/
	
	public Flux<Long> runWithInfiteLoop(){
		return Flux.interval(Duration.ofSeconds(1)).log();
	}
	
	
	
	
}
