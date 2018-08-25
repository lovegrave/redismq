package com.example.dmeo.redismq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedismqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedismqApplication.class, args);
    }
}
