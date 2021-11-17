package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.demo.service.UserService;

@SpringBootApplication
@EnableCaching
public class DemoApplication implements CommandLineRunner{

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(userService.getData());
		System.out.println(userService.getData());
		
	}
	
}
