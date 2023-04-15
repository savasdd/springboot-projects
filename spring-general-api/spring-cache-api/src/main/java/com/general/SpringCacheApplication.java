package com.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {
    public static void main(String[] args) {
       var context= SpringApplication.run(SpringCacheApplication.class,args);
    }
}