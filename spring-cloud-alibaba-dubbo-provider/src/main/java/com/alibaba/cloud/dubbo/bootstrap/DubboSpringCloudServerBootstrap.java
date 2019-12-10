package com.alibaba.cloud.dubbo.bootstrap;

import com.mingyisoft.springcloudalibaba.dubbo.entity.User;
import com.mingyisoft.springcloudalibaba.dubbo.service.YangService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Dubbo Spring Cloud Server Bootstrap.
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
public class DubboSpringCloudServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(DubboSpringCloudServerBootstrap.class);
    }
}

@Service//Dubbo 服务注解，仅声明该 Java 服务（本地）实现为 Dubbo 服务
class YangServiceImpl implements YangService {

    @Override
    public String say(String name) {
        return "hello " + name;
    }

    @Override
    public User listen(User user) {
        user.setAge(88);
        user.setName("888");
        return user;
    }
}