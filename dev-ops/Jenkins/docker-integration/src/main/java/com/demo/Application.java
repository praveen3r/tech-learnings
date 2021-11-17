package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Springboot application from jenkins");
		Path path = Paths.get("/usr/local/HelloWorld.txt");
		System.out.println(path);
		try {
			Files.createFile(path);
		} catch (Exception e) {
			System.out.println("exception is "+e);
		}
		System.out.println("File created");
	}

	
}