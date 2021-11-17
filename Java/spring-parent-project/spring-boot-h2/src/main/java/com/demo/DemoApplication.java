package com.demo;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoApplication.class);
		sp.run(args);
	}
	
	/*
	 * @Bean(initMethod = "start", destroyMethod = "stop") public Server
	 * inMemoryH2DatabaseaServer() throws SQLException { return
	 * Server.createTcpServer( "-tcp", "-tcpAllowOthers", "-tcpPort", "9090"); }
	 */
}
