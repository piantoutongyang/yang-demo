package com.mingyisoft.shardingjdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.mingyisoft.shardingjdbcdemo.*.dao")
public class ShardingJDBCDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingJDBCDemoApplication.class, args);
	}
}
