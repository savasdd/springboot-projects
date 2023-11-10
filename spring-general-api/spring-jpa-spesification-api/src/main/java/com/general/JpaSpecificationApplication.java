package com.general;


import com.general.db.CreatingDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaSpecificationApplication {
    public static void main(String[] args) {
        CreatingDatabase.builder().build();
        SpringApplication.run(JpaSpecificationApplication.class, args);
    }
}