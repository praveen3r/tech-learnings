package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.demo.config.AppConfig;
import com.demo.model.Product;
import com.demo.publisher.MessageSender;

public class MessageProducerApp
{

	public static void main(String[] args)
	{
		publishObject();
	}
	
	public static void publishText() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		messageSender.sendMessage("Hi Corona, How are you?");
		System.out.println("Message has been sent successfully...");

		((AbstractApplicationContext) context).close();
	}
	
	public static void publishObject() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);

		messageSender.sendMessage(product);
		System.out.println("Message has been sent successfully...");

		((AbstractApplicationContext) context).close();
	}

}
