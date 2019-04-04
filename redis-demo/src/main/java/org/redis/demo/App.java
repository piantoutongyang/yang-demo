package org.redis.demo;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("127.0.0.1",6379); // 创建客户端 设置IP和端口
        jedis.set("name", "alex"); // 设置值
        String value=jedis.get("name"); // 获取值
        System.out.println(value);
        jedis.close(); // 释放连接资源
	}
}

