package com.demo.service;

import java.math.BigInteger;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import com.demo.entity.User;
import com.demo.model.UserVO;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public Flux<User> getData(){
		Flux<User> userFlux = null;
		try {
			userFlux = Flux.defer(() -> Flux.fromIterable(userRepository.findAll()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userFlux;
	}
	
	public Flux<UserVO> getData1(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		//interval.subscribe((i) -> Flux.fromIterable(userRepository.findById(new BigInteger("1"))));
		//Flux<User> userFlux = Flux.defer(() -> Flux.fromIterable(userRepository.findAll()));
		 Flux<UserVO> userFlux = Flux.fromStream(Stream.generate(() -> new UserVO((userRepository.findById(new BigInteger("1")).get()), new Date())));
	       
		return Flux.zip(interval, userFlux).map(Tuple2::getT2);
		 
	}
	
	/*public Flux<UserVO1> getData1(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		//interval.subscribe((i) -> Flux.fromIterable(userRepository.findById(new BigInteger("1"))));
		//Flux<User> userFlux = Flux.defer(() -> Flux.fromIterable(userRepository.findAll()));
		 //Flux<UserVO> userFlux = Flux.fromStream(Stream.generate(() -> new UserVO((userRepository.findById(new BigInteger("1")).get()), new Date())));
		Flux<UserVO1> userFlux = Flux.fromStream(Stream.generate(() -> new UserVO1(userRepository.findAll(), new Date())));
	       
		return Flux.zip(interval, userFlux).map(Tuple2::getT2);
		 
	}*/
	
	public List<User> getData2(){
		return userRepository.findAll();
		 
	}
	
	public User getData3(){
		return userRepository.findById(new BigInteger("1")).get();
	}
	
	public Mono<User> getData4(){
		Mono<User> userMono = null;
		try {
			//userMono = Mono.create((user) -> (userRepository.findById(new BigInteger("1")).get()));
			userMono = Mono.just((userRepository.findById(new BigInteger("1")).get()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userMono;
	}
	
	
}
