package com.general.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CategoryProcess {

    private String name;

    public void changeName(){
        var temp=getName();
        System.out.println("change name: "+temp);
    }

}
