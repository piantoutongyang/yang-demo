package org.kafka.demo;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
	private static final String TOPIC = "yang-demo-topic1";
	private static final String BROKER = "127.0.0.1:9092";
	
	public static void main(String[] argus) {
		Properties props = new Properties();
		props.put("bootstrap.servers", BROKER);
		// 用来唯一标识consumer进程所在组的字符串，如果设置同样的group id，表示这些processes都是属于同一个consumer group
		props.put("group.id", "group1");
		// 如果为真，consumer所fetch的消息的offset将会自动的同步到zookeeper。这项提交的offset将在进程挂掉时，由新的consumer使用
		props.put("enable.auto.commit", "true");
		// consumer向zookeeper提交offset的频率
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		// 订阅topic，可以为多个用,隔开Arrays.asList("topic1","topic2");
		consumer.subscribe(Arrays.asList(TOPIC));

		while (true) {
			ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

			for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
				System.out.println(consumerRecord.value());
			}
		}
	}
}
