package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

	
	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).parameterName("mediaType").defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}
	 
	
	@Override 
	public void addCorsMappings(CorsRegistry registry) { 
	registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
	} 
}
