package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Value("${test.value:test}")
	String testVal;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Springboot application from kubernetes");
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("value from configuration is " + testVal);
		
	}

	
}