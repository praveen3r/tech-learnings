package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.demo")
@Import({ JmsListenerConfiguration.class })
public class AppConfig
{

	// Put Other Application configuration here.
}
