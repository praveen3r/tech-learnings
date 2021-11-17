package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

//@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan
public class DemoApplication {

	@Autowired
	Environment environment;
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SpringApplication.run(DemoApplication.class, args);
		/*new SpringApplicationBuilder().sources(DemoApplication.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);*/
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		//sp.setAdditionalProfiles("sit");
		sp.run(args);
	}

}
