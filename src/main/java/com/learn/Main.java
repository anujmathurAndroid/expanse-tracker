package com.learn;

@EnableFeignClients
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        System.out.println("Application Main Service is started...");
    }
}