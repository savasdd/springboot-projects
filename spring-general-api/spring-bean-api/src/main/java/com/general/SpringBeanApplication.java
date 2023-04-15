package com.general;

import com.general.service.AccountService;
import com.general.service.CategoryService;
import com.general.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanApplication {

    public static void main(String[] args) {
        var context= SpringApplication.run(SpringBeanApplication.class,args);
        beanAnnitation(context);
    }

    private static void beanAnnitation(ConfigurableApplicationContext context){
        var category=context.getBean(CategoryService.class);
        var stock=context.getBean(StockService.class);

        //getPersonelRepository singelton olduğu için referans değeleri aynı oluyor ve sonuç true oluyor
        var equals=category.getRepository()== stock.getRepository();
        //CategoryProcess sınıfında bean oluştururken scope olarak prototype verildiği için referans değeri farklı oluyor ve sonuç false oluyor
        var process=category.getCategoryProcess()== stock.getCategoryProcess();
        category.process();
        stock.process();

        System.out.println("repository: "+equals);
        System.out.println("process: "+process);

        //scope verildiği için iki nesne referans değeri farklı çıkmaktadır
        var account1=context.getBean("accountService", AccountService.class);
        var account2=context.getBean("accountService", AccountService.class);
        var account=account1==account2;
        System.out.println("account: "+account);


    }
}

