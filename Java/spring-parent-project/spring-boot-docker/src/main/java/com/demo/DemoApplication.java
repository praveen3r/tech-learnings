package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);
    }
}
