package com.mingyisoft.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.mingyisoft.demo.user.dao")
@EnableCaching//用于缓存标签
public class MingyisoftDemoApplication {
	public static final Logger logger = LoggerFactory.getLogger("aaa");
	public static void main(String[] args) {
		SpringApplication.run(MingyisoftDemoApplication.class, args);
	}
}
