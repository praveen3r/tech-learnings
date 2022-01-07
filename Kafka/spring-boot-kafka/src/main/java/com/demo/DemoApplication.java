package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.publisher.SimplePublisherWithAck;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	//SimplePublisher publisher;
	//JsonPublisher publisher;
	SimplePublisherWithAck publisher;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		publisher.send();		
	}

}
