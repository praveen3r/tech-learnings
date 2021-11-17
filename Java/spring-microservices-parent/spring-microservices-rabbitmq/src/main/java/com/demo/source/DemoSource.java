package com.demo.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DemoSource {
	
	String PUBLISH_CHANNEL = "demoChannel";
	String SUBSCRIBE_CHANNEL = "demoSubChannel";
	
	@Output("demoChannel")
	MessageChannel userChannel();
	
	 @Input(SUBSCRIBE_CHANNEL)
	 SubscribableChannel greeting();

}
