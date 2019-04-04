package org.springboot2.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
    private String formMail;
	
	@RequestMapping("/hello")
	public Object hello() {
		logger.error("我是error");
		logger.warn("我是warn");
		logger.info("我是info");
		logger.debug("我是debug");
		logger.trace("我是trace");
		
		try {
			int a = 1/0;
		} catch (Exception e) {
			logger.error("", e);
		}
		
		return jdbcTemplate.queryForList("select * from t_user ");
	}
	
	@RequestMapping("/hello2")
	public Demo hello2() {
		Demo d = new Demo();
		d.setAge(12);
		d.setName("aaaa");
		return d;
	}
	
	@RequestMapping("/email")
	public Demo email() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
   	 	simpleMailMessage.setFrom(formMail);
        simpleMailMessage.setTo("171757607@qq.com");
        simpleMailMessage.setSubject("guitiy");
        simpleMailMessage.setText("choucked");
        try {
        	javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
		
		Demo d = new Demo();
		d.setAge(12);
		d.setName("aaaa");
		return d;
	}
}

class Demo{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
