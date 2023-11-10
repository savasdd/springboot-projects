package com.general.service;

import com.general.data.options.DataSourceLoadOptions;
import com.general.data.response.LoadResult;
import com.general.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    Department save(Department dto);

    LoadResult getAllLoad(DataSourceLoadOptions loadOptions);
}
