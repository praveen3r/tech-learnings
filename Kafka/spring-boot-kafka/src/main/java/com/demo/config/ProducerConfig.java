package com.demo.config;

import org.omg.CORBA.portable.CustomValue;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public class ProducerConfig {

	/*@Bean
	public ProducerFactory<Integer, CustomValue> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs(), null, () -> new CustomValueSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, CustomValue> kafkaTemplate() {
	    return new KafkaTemplate<Integer, CustomValue>(producerFactory());
	}*/
}
