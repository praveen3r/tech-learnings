package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.service.UserService;

@SpringBootApplication()
public class MainApp implements CommandLineRunner{

	@Autowired
    private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(MainApp.class);
		sp.run(args);
		 /*AnnotationConfigApplicationContext context =
	              new AnnotationConfigApplicationContext(DemoConfig.class);*/
		

	}
	
	@Override
    public void run(String... args) throws Exception {
		 UserService userService = context.getBean(UserService.class);
		 userService.getEmployeeResource();
       
	}


}
