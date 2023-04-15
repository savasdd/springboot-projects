package com.general.service;

import com.general.repository.CategoryRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryProcess categoryProcess;

    public CategoryService(CategoryRepository repository, CategoryProcess categoryProcess) {
        this.repository = repository;
        this.categoryProcess = categoryProcess;
    }

    public void process(){
        categoryProcess.setName("banner");
        categoryProcess.changeName();
    }

    public CategoryRepository getRepository() {
        return repository;
    }

    public CategoryProcess getCategoryProcess() {
        return categoryProcess;
    }
}
