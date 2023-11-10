package com.general.service;

import com.general.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    Department save(Department dto);
}
