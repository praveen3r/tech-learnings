package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);
		

	}
}
