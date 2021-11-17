package com.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public String getName(){
		System.out.printf("calling async method from thread: %s%n",
                Thread.currentThread().getName());
		return "test";
	}
}
