package org.kafka.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Productor {
	private static final String TOPIC = "yang-demo-topic1";
	
	public static void main(String[] argus) {
//		//同步
//		Properties properties = new Properties();
//		// 客户端用于建立与kafka集群连接的host:port组，如果有多个broker,则用“,”隔开
//		// "host1:port1,host2:port2,host3,post3"
//		properties.put("bootstrap.servers", "127.0.0.1:9092");
//		// producer在向servers发送信息后，是否需要serveres向客户端（producer）反馈接受消息状态用此参数配置
//		// acks=0:表示producer不需要等待集群服务器发送的确认消息；acks=1:表示producer需要等到topic对应的leader发送的消息确认；
//		// acks=all:表示producer需要等到leader以及所有followers的消息确认，这是最安全的消息保障机制
//		properties.put("acks", "all");
//		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		properties.put("buffer.memory", "33554432");
//
//		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
//
//		for (int i = 0; i < 100; i++) {
//			String message = "Sync : this is the " + i + "th message for test!";
//			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC, message);
//			producer.send(producerRecord);
//			System.out.println("开始生产啦");
//		}
//
//		producer.close();

		// 异步

		Properties props1 = new Properties();
		props1.put("bootstrap.servers", "127.0.0.1:9092");
		props1.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props1.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props1.put("producer.type", "async");
		props1.put("batch.size", "16384");

		Producer<String, String> producer = new KafkaProducer<String, String>(props1);

		for (int i = 0; i < 100; i++) {
			String message = "Async : this is the " + i + "th message for test!";
			ProducerRecord producerRecord = new ProducerRecord(TOPIC, message);
			producer.send(producerRecord);
			System.out.println("开始生产啦222");
		}

		producer.close();
	}
}
