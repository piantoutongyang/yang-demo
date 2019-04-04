package org.springboot2.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class DemoBean {
	@Value("${server.port}")
	public String port;
	@Value("${server.address}")
	public String address;
}
