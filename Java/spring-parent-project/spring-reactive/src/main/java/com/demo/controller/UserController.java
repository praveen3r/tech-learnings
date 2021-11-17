/*package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.demo.entity.User;
import com.demo.model.UserVO;
import com.demo.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public ResponseEntity<Flux<User>> rest1() {
		Flux<User> userList = userService.getData();
		ResponseEntity<Flux<User>> response = new ResponseEntity<Flux<User>>(userList,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<UserVO>> rest2() {
		Flux<UserVO> userList = userService.getData1();
		ResponseEntity<Flux<UserVO>> response = new ResponseEntity<Flux<UserVO>>(userList,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<UserVO1>> rest2() {
		Flux<UserVO1> userList = userService.getData1();
		ResponseEntity<Flux<UserVO1>> response = new ResponseEntity<Flux<UserVO1>>(userList,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.GET)
	public ResponseEntity<Mono<User>> rest5() {
		Mono<User> userMono = userService.getData4();
		ResponseEntity<Mono<User>> response = new ResponseEntity<Mono<User>>(userMono,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public ResponseEntity<List<User>> rest3() {
		List<User> userList = userService.getData2();
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public ResponseEntity<User> rest4() {
		User user = userService.getData3();
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.OK);
		return response;
	}
}
*/