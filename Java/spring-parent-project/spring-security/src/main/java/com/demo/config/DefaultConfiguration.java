package com.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

//@Import({WebSecurityConfiguration.class, ViewResolverConfiguration.class})
//@Import({WebSecurityConfiguration.class})
@ComponentScan(basePackages="com.demo")
@EnableAutoConfiguration
public class DefaultConfiguration{

	 
	
	
}
