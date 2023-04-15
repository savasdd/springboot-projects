package com.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisApplication {
    public static void main(String[] args) {
       var context= SpringApplication.run(SpringRedisApplication.class,args);
    }
}