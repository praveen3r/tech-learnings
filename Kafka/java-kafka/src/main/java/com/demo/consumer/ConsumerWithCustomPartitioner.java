package com.demo.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class ConsumerWithCustomPartitioner {

	public static void main(String[] args) throws Exception {
        String topicName = "test";
        KafkaConsumer<String, String> consumer = null;
        int rCount;

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "false");

        consumer = new KafkaConsumer<>(props);
        TopicPartition p0 = new TopicPartition(topicName, 0);
        TopicPartition p1 = new TopicPartition(topicName, 1);
        TopicPartition p2 = new TopicPartition(topicName, 2);

        consumer.assign(Arrays.asList(p0, p1, p2));
        System.out.println("Current position p0=" + consumer.position(p0)
                + " p1=" + consumer.position(p1)
                + " p2=" + consumer.position(p2));

        consumer.seek(p0, getOffsetFromDB(p0));
        consumer.seek(p1, getOffsetFromDB(p1));
        consumer.seek(p2, getOffsetFromDB(p2));
        System.out.println("New positions po=" + consumer.position(p0)
                + " p1=" + consumer.position(p1)
                + " p2=" + consumer.position(p2));

        System.out.println("Start Fetching Now");
        try {
            do {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                System.out.println("Record polled " + records.count());
                rCount = records.count();
                for (ConsumerRecord<String, String> record : records) {
                    //saveAndCommit(consumer, record);
                }
            } while (rCount > 0);
        } catch (Exception ex) {
            System.out.println("Exception in main.");
        } finally {
            consumer.close();
        }
    }

    private static long getOffsetFromDB(TopicPartition p) {
       /* long offset = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "pandey");

            String sql = "select offset from tss_offsets where topic_name='"
                    + p.topic() + "' and partition=" + p.partition();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                offset = rs.getInt("offset");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Exception in getOffsetFromDB");
        }
        return offset;*/
    	return 0;
    }

}
