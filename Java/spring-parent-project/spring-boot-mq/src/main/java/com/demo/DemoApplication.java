package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.demo.dto.Employee;

@SpringBootApplication
@EnableJms
public class DemoApplication {
	
	public static void main(String[] args) throws Exception{
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

       JmsTemplate jmsOperations = context.getBean(JmsTemplate.class);
        //jmsTemplate.setConnectionFactory(connFactory);
        // Send a message with a POJO - the template reuse the message converter
        jmsOperations.convertAndSend("TEST", new Employee(12,"test"));
    }
	

    
}
