package com.general.service.impl;

import com.general.entity.Department;
import com.general.repository.DepartmentRepository;
import com.general.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public List<Department> getAll() {
        var list = repository.findAll();

        return list;
    }

    @Override
    public Department save(Department dto) {
        var model = repository.save(dto);

        log.info("create department", model.getId());
        return model;
    }
}
