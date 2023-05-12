package com.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMinioApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(SpringMinioApplication.class, args);
    }
}