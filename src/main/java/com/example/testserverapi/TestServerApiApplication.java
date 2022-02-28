package com.example.testserverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.testserverapi.mapper"})
public class TestServerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServerApiApplication.class, args);
    }

}
