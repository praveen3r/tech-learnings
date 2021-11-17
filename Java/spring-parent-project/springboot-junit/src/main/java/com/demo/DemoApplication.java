package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class DemoApplication {

	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);
	}

}
