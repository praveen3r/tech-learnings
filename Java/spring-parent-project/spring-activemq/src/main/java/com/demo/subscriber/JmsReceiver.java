package com.demo.subscriber;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.demo.model.Product;

@Component
public class JmsReceiver {


	@JmsListener(destination = "message_queue")
	public void receiveMessage(final Message<Product> message)
			throws JMSException
	{
		MessageHeaders headers = message.getHeaders();
		System.out.println("headers = " + headers);

		Product product = message.getPayload();
		System.out.println("product = " + product);

	}
}
