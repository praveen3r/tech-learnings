package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.demo.config.AppConfig;
import com.demo.model.Product;
import com.demo.subscriber.MessageReceiver;

public class MessageConsumerApp
{

	public static void main(String[] args)
	{
		receiveObject();
	}
	
	public static void receiveText() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
		String response = messageReceiver.receiveMessage();
		System.out.println("Messgae Received = " + response);

		((AbstractApplicationContext) context).close();
	}
	
	public static void receiveObject() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
		Product product = messageReceiver.receiveObject();
		System.out.println("Message Received = " + product);

		((AbstractApplicationContext) context).close();
	}

}
