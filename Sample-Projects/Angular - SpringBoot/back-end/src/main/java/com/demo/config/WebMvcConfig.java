package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

	@Value("${cors.domain}")
	private String domain;
	
	@Value("${cors.allow-methods}")
	private String[] allowedMethods;
	
	@Value("${cors.allow-headers}")
	private String[] allowedHeaders;
	
	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(Boolean.TRUE).parameterName("mediaType").defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}
	 
	
	@Override 
	public void addCorsMappings(CorsRegistry registry) { 
		registry.addMapping("/**").allowedOrigins(domain).allowedMethods(allowedMethods).allowedHeaders(allowedHeaders);
	} 
}
