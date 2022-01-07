package com.demo.publisher;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class SimplePublisherWithAck {

	@Autowired
	KafkaTemplate<String, String> template;
	
	public void send(){
		ListenableFuture<SendResult<String, String>> future = template.send("test1", "test");
		/*future.addCallback(new KafkaSendCallback<String, String>() {

			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Success");
				
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
		});*/
		future.addCallback(new CustomCallBack());

	}
}
