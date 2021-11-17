package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
    private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);

	}
	
	@Override
    public void run(String... args) throws Exception {
		EmailService emailService = context.getBean(EmailService.class);
		emailService.sendEmail();
	      
       
	}

}
