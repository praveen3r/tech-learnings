package com.demo.subscriber;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.demo.custom.CustomListener;

@Service
public class SimpleSubscriber {

	/*@KafkaListener(id = "myId", topics = "test1")
    public void listen(String in) {
        System.out.println(in);
    }
	
	@KafkaListener(id = "myId", topics = "test1",
	        autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
	public void listenWithConcurrency(String data) {
		System.out.println(data);
	}
	
	@KafkaListener(id = "thing2", topicPartitions = { @TopicPartition(topic = "topic1", partitions = { "0", "1" }),
			@TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100")) })
	public void listenWithExplicitPartitionAssignment(String data) {
		System.out.println(data);
	}*/
	
	/**
	 * The * wildcard represents all partitions in the partitions attribute. There must only be one @PartitionOffset with the wildcard in each @TopicPartition
	 * @param data
	 */
	/*
	@KafkaListener(id = "thing3", topicPartitions =
        { @TopicPartition(topic = "topic1", partitions = { "0", "1" },
             partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0"))
        })
	public void listenWithExplicitPartitionAssignment2(String data) {
		System.out.println(data);
	}
	
	@KafkaListener(id = "pp", autoStartup = "false",
	        topicPartitions = @TopicPartition(topic = "topic1",
	                partitions = "0-5, 7, 10-15"))
	public void listenWithCommaDelimitedListOfPartitionsOrPartitionRanges(String data) {
		System.out.println(data);
	}
	
	@KafkaListener(id = "thing3", topicPartitions =
        { @TopicPartition(topic = "topic1",
             partitionOffsets = @PartitionOffset(partition = "0-5", initialOffset = "0"))
        })
	public void listenWithCommaDelimitedListOfPartitionsOrPartitionRangesWithInitialOffset(ConsumerRecord<?, ?> record) {
	    System.out.println(data);
	}
	
	
    @KafkaListener(id = "cat", topics = "myTopic", containerFactory = "kafkaManualAckListenerContainerFactory")
	public void listenWithManualAcknowledgement(String data, Acknowledgment ack) {
		ack.acknowledge();
	}

	@KafkaListener(id = "cat", topics = "myTopic", containerFactory = "kafkaManualAckListenerContainerFactory")
	public void listenWithManualAcknowledgement(String data, Acknowledgment ack) {
		ack.acknowledge();
	}

	@KafkaListener(id = "qux", topicPattern = "myTopic1")
	public void listenWithDiscreteHeaders(@Payload String data,
			@Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) Integer key,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
		System.out.println(data);
	}

	@KafkaListener(id = "qux", topicPattern = "myTopic1")
	public void listenWithHeadersUsingConsumerRecordMetadata(String data, ConsumerRecordMetadata meta) {
		System.out.println(data);
	}
	
	@KafkaListener(topics = "myTopic", groupId = "group", properties = { "max.poll.interval.ms:60000",
			ConsumerConfig.MAX_POLL_RECORDS_CONFIG + "=100" })
	public void listenWithCustomProperties(String data, ConsumerRecordMetadata meta) {
		System.out.println(data);
	}
	
	@KafkaListener(id = "two", topics = "two",
	        properties = "value.deserializer:org.apache.kafka.common.serialization.ByteArrayDeserializer")
	public void listen2(byte[] in) {
	    System.out.println("2: " + new String(in));
	}
	
	@CustomListener(id = "my.group", topics = "my.topic")
	public void listen1(String data) {
		System.out.println(data);
	}

	*/
	
	
	
	
	
}
