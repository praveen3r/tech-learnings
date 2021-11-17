package com.demo.test.mq;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class JmsMQSubscriber {

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
       
       // receive the messages
       MessageConsumer messageConsumer = session.createConsumer(queue);
       
       connection.start();
       
       Message message = messageConsumer.receive(15000);

       // check if a message was received
       if (message != null) {
    	   
	         // cast the message to the correct type
	         TextMessage textMessage = (TextMessage) message;

	         // retrieve the message content
	         String text = textMessage.getText();
         
                                                                           
	        // print what we did
	        System.out.println("Message received: " + text);
       }
                                                                           
       // close the Queue connection
       connection.close();

	}

}
