package com.demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class PublisherApplication 
{
	//private static final String EXCHANGE_NAME = "test-exchange";
	private static final String EXCHANGE_NAME = "test-exchange";
	
    public static void main( String[] args ) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
		  factory.setPort(5672); 
		  factory.setUsername("guest");
		  factory.setPassword("guest");
		 
        try (
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()){
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true);
        String message = "Helloworld message1 - " ;
        channel.basicPublish(EXCHANGE_NAME, "test-routing-key", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");

        }
        
    }
}
