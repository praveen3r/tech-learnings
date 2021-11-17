package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DemoConfig {

	@Bean
	public WebClient webClient(WebClient.Builder webClientBuilder) {
		//return webClientBuilder.baseUrl("http://example.org").defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE).build();
		return webClientBuilder.build();
	}
	
	
}
