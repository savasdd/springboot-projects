package com.general.service;

import com.general.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person save(Person dto);
}
