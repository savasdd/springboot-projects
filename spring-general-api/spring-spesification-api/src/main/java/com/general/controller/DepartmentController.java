package com.general.controller;

import com.general.data.options.DataSourceLoadOptions;
import com.general.data.response.LoadResult;
import com.general.entity.Department;
import com.general.entity.Person;
import com.general.service.DepartmentService;
import com.general.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(value = "/all")
    public LoadResult findAll(@RequestBody DataSourceLoadOptions loadOptions) {
        return service.getAllLoad(loadOptions);
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return new ResponseEntity<>(service.save(department), HttpStatus.CREATED);
    }
}
