package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class MainApp {

	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(MainApp.class);
		sp.run(args);
		

	}
	
	


}
