package com.demo.scheduler.service;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CronJobParam {

	private String name;
	
	private String group;
	
	private String description;
	
	private String cronExpression;
	
	private String timeZoneId;
	
	private Map<String, Object> dataMap;
}
