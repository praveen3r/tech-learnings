package com.skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {
	public static void main(String[] args){
		SpringApplication sp=new SpringApplication(EmployeeApplication.class);
		sp.run(args);
	}
}
