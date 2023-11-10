package com.general;


import com.general.db.CreatingDatabase;
import com.general.repository.base.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.general.entity", "com.general.repository"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class SpecificationApplication {
    public static void main(String[] args) {
        CreatingDatabase.builder().build();
        SpringApplication.run(SpecificationApplication.class, args);
    }
}