package com.demo.config;

import java.util.function.BiConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.DefaultAfterRollbackProcessor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;

public class ErrorHandlerConfig {

	@Bean
	public ConsumerAwareListenerErrorHandler listen3ErrorHandler() {
	    return (m, e, c) -> {
	        MessageHeaders headers = m.getHeaders();
	        c.seek(new org.apache.kafka.common.TopicPartition(
	                headers.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
	                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class)),
	                headers.get(KafkaHeaders.OFFSET, Long.class));
	        return null;
	    };
	}
	
	@Bean
	public DefaultAfterRollbackProcessor errorHandler(BiConsumer<ConsumerRecord<?, ?>, Exception> recoverer) {
	    DefaultAfterRollbackProcessor processor = new DefaultAfterRollbackProcessor(recoverer);
	    processor.addNotRetryableExceptions(IllegalArgumentException.class, ClassNotFoundException.class);
	    return processor;
	}
}
