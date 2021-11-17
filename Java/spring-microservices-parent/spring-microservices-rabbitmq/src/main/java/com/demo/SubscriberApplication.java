package com.demo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.demo.source.DemoSource;

@SpringBootApplication
@EnableBinding(DemoSource.class)
public class SubscriberApplication {

	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(SubscriberApplication.class);
		sp.run(args);

	}
	
	
	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test-queue", durable = "true"), 
			exchange = @Exchange(value = "test-exchange", type = "topic", durable = "true"), key = "test-routing-key"))
	public void receivedMessage(String msg) {
		System.out.println("Received Message: " + msg);
	}
	 
	
	/*
	 * @StreamListener(target=DemoSource.SUBSCRIBE_CHANNEL) public void
	 * receivedMessage(String msg) { System.out.println("Received Message: " + msg);
	 * }
	 */

}
