package com.general.controller;

import com.general.data.options.DataSourceLoadOptions;
import com.general.data.responseModel.LoadResult;
import com.general.entity.Person;
import com.general.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(value = "/all")
    public LoadResult findAll(@RequestBody DataSourceLoadOptions loadOptions) {
        return service.getAllLoad(loadOptions);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.save(person), HttpStatus.CREATED);
    }
}
