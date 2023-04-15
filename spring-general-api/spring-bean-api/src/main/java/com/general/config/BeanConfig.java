package com.general.config;

import com.general.service.AccountService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    AccountService accountService(){
        return new AccountService();
    }
}
