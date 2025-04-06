package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication  {
    public static void main(String[] args) {

        SpringApplication.run(UserServiceApplication.class, args);
        System.out.println("Application User Service is started...");
    }
}