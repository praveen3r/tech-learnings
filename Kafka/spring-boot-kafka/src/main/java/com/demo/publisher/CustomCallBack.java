package com.demo.publisher;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.support.SendResult;

public class CustomCallBack implements KafkaSendCallback<String, String>{

	public void onSuccess(SendResult<String, String> result) {
		System.out.println("Success");
		System.out.println(result.getProducerRecord().topic());
		System.out.println(result.getRecordMetadata().timestamp());
		System.out.println(result.getRecordMetadata().partition());
		
	}

	public void onFailure(Throwable ex) {
		System.out.println("failure");
		
	}

	public void onFailure(KafkaProducerException ex) {
		ProducerRecord<Integer, String> failed = ex.getFailedProducerRecord();
		System.out.println("failure is due to");
		System.out.println(failed.topic());
		System.out.println(failed.value());
		
	}

	
}
