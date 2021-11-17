package com.demo.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.PlatformTransactionManager;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJms
@Slf4j
public class MQLocalConfiguration {

	@Value("${mq.host}")
	String host;
	
	@Value("${mq.port}")
	int port;
	
	@Value("${mq.queueManager}")
	String queueManager;
	
	@Value("${mq.receive.timeout}")
	long receiveTimeout;
	
	@Value("${mq.session.cache}")
	int cacheSize;
	
	@Bean(name = "mqQueueConnectionFactory")
	public ConnectionFactory mqQueueConnectionFactory()  {

	    MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
	    mqQueueConnectionFactory.setHostName(host);
	    try {
	        mqQueueConnectionFactory.setTargetClientMatching(true);
	        mqQueueConnectionFactory.setCCSID(1208);
	        mqQueueConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
	        //mqQueueConnectionFactory.setChannel(channel);
	        mqQueueConnectionFactory.setPort(port);
	        mqQueueConnectionFactory.setQueueManager(queueManager);


	    } catch (Exception e) {
	        log.error("Error while creating mq connection factory");
	    }
	    return mqQueueConnectionFactory;
	}

	@Bean(name = "userCredentialsConnectionFactoryAdapter")
	UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter(
			@Qualifier("mqQueueConnectionFactory") MQQueueConnectionFactory mqQueueConnectionFactory) {
	    UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter = new UserCredentialsConnectionFactoryAdapter();
	   /* userCredentialsConnectionFactoryAdapter.setUsername(username);
	    userCredentialsConnectionFactoryAdapter.setPassword(password);*/
	    userCredentialsConnectionFactoryAdapter.setTargetConnectionFactory(mqQueueConnectionFactory);
	    return userCredentialsConnectionFactoryAdapter;
	}

	@Bean(name = "cachingConnectionFactory")
	@Primary
	public CachingConnectionFactory cachingConnectionFactory(
			@Qualifier("userCredentialsConnectionFactoryAdapter") UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter) {
	    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
	    cachingConnectionFactory.setTargetConnectionFactory(userCredentialsConnectionFactoryAdapter);
	    cachingConnectionFactory.setSessionCacheSize(cacheSize);
	    cachingConnectionFactory.setReconnectOnException(true);
	    return cachingConnectionFactory;
	}

	@Bean(name = "jmsTransactionManager")
	public PlatformTransactionManager jmsTransactionManager(@Qualifier("cachingConnectionFactory") CachingConnectionFactory cachingConnectionFactory) {
	    JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
	    jmsTransactionManager.setConnectionFactory(cachingConnectionFactory);
	    return jmsTransactionManager;
	}
	
	@Bean(name="queueTemplate")
    public JmsMessagingTemplate queueTemplate(@Qualifier("cachingConnectionFactory") CachingConnectionFactory cachingConnectionFactory, 
    		@Qualifier("jacksonJmsMessageConverter") MessageConverter messagingMessageConverter) {
        JmsMessagingTemplate queueTemplate = new JmsMessagingTemplate(cachingConnectionFactory);
        queueTemplate.setJmsTemplate(jmsTemplate(cachingConnectionFactory));
        return queueTemplate;
    }

	@Bean(name = "jmsTemplate")
	public JmsTemplate jmsTemplate(@Qualifier("cachingConnectionFactory") CachingConnectionFactory cachingConnectionFactory) {
	    JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
	    jmsTemplate.setPubSubDomain(false);
	    jmsTemplate.setReceiveTimeout(receiveTimeout);
	    jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
	    return jmsTemplate;
	}

	@Bean(name = "jmsListenerContainerFactory")
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory(@Qualifier("cachingConnectionFactory") CachingConnectionFactory cachingConnectionFactory,
	        DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setReceiveTimeout(receiveTimeout);
	    configurer.configure(factory, cachingConnectionFactory);
	    return factory;
	}

	@Bean(name = "jacksonJmsMessageConverter")
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    converter.setObjectMapper(objectMapper);
	    return converter;
	}
}
