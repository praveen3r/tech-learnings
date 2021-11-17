package com.demo.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.demo.model.FileDto;
import com.demo.model.ValueDto;


@RestController
@RequestMapping("/webclient/")
public class WebClientPublisherController {
	
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public String rest1() {
		return "Hello World";
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public List<String> rest2() {
		return Arrays.asList("test1","test2");
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public String rest3(@RequestParam("id") String id) {
		return id;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public String rest4(@RequestHeader("id") String id) {
		return id;
	}
	
	@RequestMapping(value = "rest41", method = RequestMethod.GET)
	public Mono<String> rest41() {
		return Mono.just("Happy Mono world");
	}
	
	@RequestMapping(value = "rest42", method = RequestMethod.GET)
	public Flux<String> rest42() {
		return Flux.just("Happy Flux world1","Happy Flux world2");
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.POST)
	public String rest5(@RequestBody String id) {
		return id;
	}
	
	//Form data application/x-www-form-urlencoded
	@RequestMapping(value = "rest6", method = RequestMethod.POST)
	public String rest6(ValueDto value) {
		return value.getId();
	}
	
	@RequestMapping(value = "rest7", method = RequestMethod.POST)
	public String rest7(@RequestBody String monoStr) {
		 return monoStr;
	}
	
	@RequestMapping(value = "rest71", method = RequestMethod.POST)
	public ResponseEntity<String> rest71(FileDto value) {
		System.out.println(value.getFile());
		ResponseEntity<String> response = new ResponseEntity<String>("Success",HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest72", method = RequestMethod.POST)
	public Mono<String> rest7(@RequestBody Mono<String> monoStr) {
		 return monoStr;
	}
	
	@RequestMapping(value = "rest8", method = RequestMethod.POST, consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
	//@RequestMapping(value = "rest7", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String rest5(@RequestBody Mono<String> mono) {
		 mono.subscribe(System.out::println);
		 return "asdf";
	}
	
	@RequestMapping(value = "rest9", method = RequestMethod.GET, produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> rest9() {
		return Flux.interval(Duration.ofSeconds(2)).take(10);
	}
	
	@RequestMapping(value = "rest10", method = RequestMethod.GET)
	public Long rest10(@RequestParam("id") long id) {
		System.out.println(id);
		return id + 10;
	}

}
