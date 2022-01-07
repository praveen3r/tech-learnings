package com.demo.subscriber;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class BatchSubscriber {

	/*

    @KafkaListener(id = "listMsg", topics = "myTopic", containerFactory = "batchFactory")
	public void listen14(List<Message<?>> list) {
	    System.out.println(list);
	}

	@KafkaListener(id = "listMsgAck", topics = "myTopic", containerFactory = "batchFactory")
	public void listen15(List<Message<?>> list, Acknowledgment ack) {
		System.out.println(list);
	}

	@KafkaListener(id = "listMsgAckConsumer", topics = "myTopic", containerFactory = "batchFactory")
	public void listen16(List<Message<?>> list, Acknowledgment ack, Consumer<?, ?> consumer) {
		System.out.println(list);
	}
	
	*/
	
	
	
	
}
