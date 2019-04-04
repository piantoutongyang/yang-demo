package org.kafka.demo.stream;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleConsumer {
	public static void main(String[] args) throws Exception {
		// Kafka consumer configuration settings
		String topicName = "WordsWithCountsTopic";
		Properties props = new Properties();
 
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
		// Kafka Consumer subscribes list of topics here.
		kafkaConsumer.subscribe(Arrays.asList(topicName));
 
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {
				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
			}
		}
	}
}
