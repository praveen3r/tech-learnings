package com.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.User;

@SpringBootApplication
public class PublisherApp implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Binding binding;
	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(PublisherApp.class);
		sp.run(args);

	}
	
	@Override
    public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		/*
		 * rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(),
		 * "Hello from Springboot!");
		 */
		
		User user = new User();
		user.setUserId("testId");
		user.setUserName("testName");
		rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), user);
	}


}
