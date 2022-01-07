package com.demo.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;

public class ConsumerConfig {

	/*@Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
                        kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.setMessageConverter(new JsonMessageConverter());
        
        factory.setCommonErrorHandler(myErrorHandler);
        
        factory.getContainerProperties().setAckOnError(false);
        factory.getContainerProperties().setAckMode(AckMode.RECORD);
        factory.setCommonErrorHandler(new DefaultErrorHandler(new FixedBackOff(1000L, 2L)));
        
        
        
        factory.getContainerProperties().setPollTimeout(3000);
        // factory.setBatchListener(true); -> to receive the entire batch of consumer records received from the consumer poll
        
        factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerAwareRebalanceListener() {

	    @Override
	    public void onPartitionsRevokedBeforeCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
	        // acknowledge any pending Acknowledgments (if using manual acks)
	    }
	
	    @Override
	    public void onPartitionsRevokedAfterCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
	        // ...
	            store(consumer.position(partition));
	        // ...
	    }
	
	    @Override
	    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
	        // ...
	            consumer.seek(partition, offsetTracker.getOffset() + 1);
	        // ...
	    }
	});
        
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, MyConsumerInterceptor.class.getName());
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, embeddedKafka.getBrokersAsString());
        ...
        return props;
    }*/
    
    
}
