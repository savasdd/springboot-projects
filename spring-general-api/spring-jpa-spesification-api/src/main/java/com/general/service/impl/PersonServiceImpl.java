package com.general.service.impl;

import com.general.entity.Person;
import com.general.repository.PersonRepository;
import com.general.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public List<Person> getAll() {
        var list = repository.findAll();

        return list;
    }

    @Override
    public Person save(Person dto) {
        var model = repository.save(dto);

        log.info("create person", model.getId());
        return model;
    }
}
