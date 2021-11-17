package com.demo.subscriber;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.demo.model.Product;

@Component
public class MessageObjListener implements MessageListener
{
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message)
	{
		try
		{
			Product product = (Product) messageConverter.fromMessage(message);

			System.out.println("------- Inside onMessage-------");
			System.out.println(product);
			System.out.println("------- Inside onMessage-------");
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}

	}
}
