package com.mingyisoft.springcloudalibabadubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class RestTemplateProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateProviderApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            System.out.println("name==="+name);
            return "hello xxxxxxxx " + name;
        }
    }
}
