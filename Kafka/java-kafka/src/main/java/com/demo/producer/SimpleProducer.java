package com.demo.producer;

import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SslConfigs;

public class SimpleProducer {

	public static void main(String[] args) {
		try {
		String topicName = "test";
		  //String key = "Key1";
		  String value = "Value-1";
	      
	      Properties props = new Properties();
	      //props.put("bootstrap.servers", "localhost:9092,localhost:9093");
	      props.put("bootstrap.servers", "10.7.200.106:9092");
	      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
	      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	      
			/*
			 * props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
			 * props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "C:/Docs/pk.jks");
			 * props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "kamala123$$");
			 */
		        
	      Producer<String, String> producer = new KafkaProducer <>(props);
		
		  //ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
	      ProducerRecord<String, String> record = new ProducerRecord<>(topicName,value);
		  producer.send(record);	       
	      producer.close();
		  
		  System.out.println("SimpleProducer Completed.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
