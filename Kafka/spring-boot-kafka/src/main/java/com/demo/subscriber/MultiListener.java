package com.demo.subscriber;

import org.springframework.kafka.annotation.KafkaHandler;

/*
 * When messages are delivered, 
 * the converted message payload type is used to determine which method to call
 * 
 * Due to some limitations in the way Spring resolves method arguments, a default @KafkaHandler 
 * cannot receive discrete headers; it must use the ConsumerRecordMetadata
 */
//@KafkaListener(id = "multi", topics = "myTopic")
public class MultiListener {

	/*@KafkaHandler
    public void listen(String foo) {
        
    }

    @KafkaHandler
    public void listen(Integer bar) {
        
    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object) {
        
    }
    
    @KafkaHandler(isDefault = true)
    void listen(Object in, @Header(KafkaHeaders.RECORD_METADATA) ConsumerRecordMetadata meta) {
       String topic = meta.topic();
    }
	   
    */

	   
}
