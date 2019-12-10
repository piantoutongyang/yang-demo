package com.alibaba.cloud.dubbo.bootstrap;

import com.mingyisoft.springcloudalibaba.dubbo.entity.User;
import com.mingyisoft.springcloudalibaba.dubbo.service.YangService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dubbo Spring Cloud Client Bootstrap
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class DubboSpringCloudClientBootstrap {

    @Reference
    private YangService yangService;

    @GetMapping("/yang")
    public String yang(String message) {
        User user = yangService.listen(new User());
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return yangService.say(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringCloudClientBootstrap.class);
    }
}
