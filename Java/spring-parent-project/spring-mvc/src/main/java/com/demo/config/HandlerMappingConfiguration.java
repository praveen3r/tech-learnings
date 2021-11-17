package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.AbstractController;

import com.demo.controller.TestWoAnnotatationController;

public class HandlerMappingConfiguration {

	@Bean
	@Order(2)
	BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
		System.out.println("coming to beanNameUrlHandlerMapping");
		return new BeanNameUrlHandlerMapping();
	}

	@Bean(name = "/account/home")
	public AbstractController resolveView() {
		return new TestWoAnnotatationController();
	}

	@Bean
	@Order(1)
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		System.out.println("coming to simpleUrlHandlerMapping");
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();

		Map<String, Object> urlMap = new HashMap<>();
		// urlMap.put("/account/home", resolveView1());
		urlMap.put("/account/home", "resolveView1");
		simpleUrlHandlerMapping.setUrlMap(urlMap);

		return simpleUrlHandlerMapping;
	}

	@Bean()
	public AbstractController resolveView1() {
		return new TestWoAnnotatationController();
	}
}
