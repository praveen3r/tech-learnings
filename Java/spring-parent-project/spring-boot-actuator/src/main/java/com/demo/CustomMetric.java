package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class CustomMetric {

	@Autowired
	CounterService counterService;
	
	public void display() {
		counterService.increment("counter.custom.success");
		counterService.increment("counter.custom.failure");
	}
}
