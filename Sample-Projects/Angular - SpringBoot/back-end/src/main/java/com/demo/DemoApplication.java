package com.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching
public class DemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		var springApplication = new SpringApplication(DemoApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);

	}
	
}
