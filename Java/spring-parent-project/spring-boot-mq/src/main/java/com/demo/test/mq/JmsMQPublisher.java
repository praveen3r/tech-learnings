package com.demo.test.mq;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class JmsMQPublisher {
	
	public static void main(String[] args) throws Exception{

		
	       JmsFactoryFactory ff =  JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
	       
	       JmsConnectionFactory connFactory = ff.createConnectionFactory();
	       connFactory.setStringProperty(WMQConstants.WMQ_HOST_NAME, "localhost");
	       connFactory.setIntProperty(WMQConstants.WMQ_PORT, 1414);
	       connFactory.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "TEST");
	       
	       // create a Queue connection
	       Connection connection = connFactory.createConnection();
	                                                                           
	       // create a Queue session
	       Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	                                                                           
	       // create a Queue publisher
	       Queue queue = session.createQueue("TEST");
	       
	       // create the "Hello World" message
	       TextMessage message = session.createTextMessage();
	       message.setText("Hello World1");
	                                                                           
	       // publish the messages
	       MessageProducer messageProducer = session.createProducer(queue);
	       messageProducer.send(message);
	                                                                           
	       // print what we did
	       System.out.println("Message published: " + message.getText());
	                                                                           
	       // close the Queue connection
	       connection.close();
	}
}
