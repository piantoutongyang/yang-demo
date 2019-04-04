package org.kafka.demo.stream;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

/**
 * 流规则定义
 * 1.将txt数据源发送到topic1:TextLinesTopic
 * 2.StreamBuilder 监听 topic1，并定制规则，输出到topic2:WordsWithCountsTopic
 * 3.consumer从topic2中获取数据，并输出
 * 
 * 启动顺序：
 * 1.启动kafka与zk
 * 2.启动producer，consumer
 * 3.启动stream
 * 
 * @author alexyang
 *
 */
public class KafkaStream {
	public static void main(String argus[]) {
		Properties props = new Properties();
		// Kafka Streams requires at least the following properties "application.id"，"bootstrap.servers"
		// each stream has unique id @see http://kafka.apache.org/21/documentation/streams/tutorial
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
		// config kafka location
		// {@see CommonClientConfigs#BOOTSTRAP_SERVERS_DOC}, config "ubuntu-02 192.168.78.132" in the hosts file in advance
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		// provide defualt serdes(serializer and deserializer)
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		
		// config the processor with DSL(Domain Specified Language)
		StreamsBuilder builder = new StreamsBuilder();
		// create a source stream from a Kafka topic named TextLinesTopic
		// 从Kafka源topic获取数据流，KStream即代表了由各个数据记录组成的数据流。
		/**
		 * KStream可以从一个或更多topic中的数据得来。
		 * KStream可以进行对数据记录的逐条转换，和其它KStream，KTable进行join操作，或aggregate成KTable。
		 */
		KStream<String, String> textLines = builder.stream("TextLinesTopic");
		
		textLines//alex自己的一个遍历，为了试一下模拟真实场景，是否能持续的走这个地方
		.foreach((key,value)->{
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh~~~~");
			System.out.println(key);
			System.out.println(value);
		});
		
		KTable<String, Long> wordCounts = textLines
				// Create new KStream: by implements {@link ValueMapper} transform map textLine to String array
				// 按空格分解成单词+将value中所有文本转换成小写形式
				.flatMapValues(textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+")))
				// select value as key
				// 将value的值赋给key
				.selectKey((key, word) -> word)
				// aggregation操作前group by key
				.groupByKey()
				// count the number of records in this new stream. use default store
				// 计算每个组中元素个数
				.count(Materialized.as("counts-store"));
		
		// write this new kstream into another Kafka topic named WordsWithCountsTopic
		// To 将结果返回Kafka
		wordCounts.toStream().to("WordsWithCountsTopic", Produced.with(Serdes.String(), Serdes.Long()));
 
		// inspect what kinds of topology is created
		Topology topology = builder.build();
		System.out.println(topology.describe());
 
		// create kafka stream 
		KafkaStreams streams = new KafkaStreams(topology, props);
		streams.start(); 
	}
}
