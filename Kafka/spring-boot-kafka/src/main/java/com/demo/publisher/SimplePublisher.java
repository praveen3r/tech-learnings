package com.demo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimplePublisher {

	@Autowired
	KafkaTemplate<String, String> template;
	
	public void send(){
		template.send("test1", "test");
	}
}
