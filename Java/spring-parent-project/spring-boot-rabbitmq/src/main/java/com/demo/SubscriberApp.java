package com.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.demo.model.User;

@Component
public class SubscriberApp{

	/*
	 * @RabbitListener(queues="${demo.rabbitmq.queue}") public void
	 * receivedMessage(String msg) { System.out.println("Received Message: " + msg);
	 * }
	 */
	

	/*
	 * @RabbitListener(queues="${demo.rabbitmq.queue}") public void
	 * receivedMessage(Message msg) { System.out.println("Received Message: " +
	 * msg); }
	 */
	
	@RabbitListener(queues="${demo.rabbitmq.queue}")
    public void receivedMessage(User msg) {
        System.out.println("Received Message: " + msg);
    }
}
