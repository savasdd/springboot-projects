package com.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateEmbededApplication {
    public static void main(String[] args) {
        var context= SpringApplication.run(HibernateEmbededApplication.class,args);
    }
}