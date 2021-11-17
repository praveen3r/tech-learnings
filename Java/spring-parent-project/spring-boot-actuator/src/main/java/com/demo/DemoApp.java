package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.system.EmbeddedServerPortFileWriter;

@SpringBootApplication
public class DemoApp {

	public static void main(String[] args) {

		SpringApplication sp = new SpringApplication(DemoApp.class);
		/*sp.addListeners(new ApplicationPidFileWriter());  
		sp.addListeners(new EmbeddedServerPortFileWriter());*/
		sp.run(args);
	}

}
