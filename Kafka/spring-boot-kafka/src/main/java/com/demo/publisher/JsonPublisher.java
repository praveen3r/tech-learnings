package com.demo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.model.User;

@Service
public class JsonPublisher {

	@Autowired
	KafkaTemplate<String, Object> template;
	
	public void send(){
		template.send("test1", new User("testName", "testEmail", "testAddr"));
	}
}
