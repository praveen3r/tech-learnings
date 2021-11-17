package com.demo.scheduler.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "scheduler")
@Setter
@Getter
public class SchedulerConfigProperties {

	private String instanceName;
	
	private String threadPoolCount;
	
	private String threadPoolPriority; 
	
	private String misfireThreshold;
	
	private String datasourceDriver;
	
	private String datasourceUrl;
	
	private String datasourceUser;
	
	private String datasourcePassword;
	
	private int startupDelay;
}
