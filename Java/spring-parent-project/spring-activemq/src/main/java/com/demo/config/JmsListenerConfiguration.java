package com.demo.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
@EnableJms
public class JmsListenerConfiguration
{

	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	private static final String MESSAGE_QUEUE = "message_queue";

	@Bean
	public ConnectionFactory connectionFactory()
	{
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.demo"));
		return connectionFactory;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(@Autowired ConnectionFactory connectionFactory)
	{
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("1-1");
		return factory;
	}

	/*
	 * Used here for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(MESSAGE_QUEUE);
		return template;
	}

	@Bean
	MessageConverter converter()
	{
		return new SimpleMessageConverter();
	}

}
