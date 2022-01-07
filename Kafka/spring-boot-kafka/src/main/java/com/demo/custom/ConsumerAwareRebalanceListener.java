package com.demo.custom;

import java.util.Collection;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.springframework.kafka.annotation.TopicPartition;

public interface ConsumerAwareRebalanceListener extends ConsumerRebalanceListener {

    void onPartitionsRevokedBeforeCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions);

    void onPartitionsRevokedAfterCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions);

    void onPartitionsAssigned(Consumer<?, ?> consumer, Collection<TopicPartition> partitions);

    void onPartitionsLost(Consumer<?, ?> consumer, Collection<TopicPartition> partitions);

}
