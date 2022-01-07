package com.demo.subscriber;

import javax.validation.Valid;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.messaging.handler.annotation.Payload;

import com.demo.model.ValidatedClass;

public class SubscriberWithValidation {

	/*@KafkaListener(id="validated", topics = "annotated35", errorHandler = "validationErrorHandler",
		      containerFactory = "kafkaJsonListenerContainerFactory")
		public void validatedListener(@Payload @Valid ValidatedClass val) {
		    System.out.println(val);
		}

		@Bean
		public KafkaListenerErrorHandler validationErrorHandler() {
		    return (m, e) -> {
		    	System.out.println(m);
		    	return null;
		    };
		}*/
}
