package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServiceApplication.class, args);
        System.out.println("Application Configuration Server Service is started...");
    }
}