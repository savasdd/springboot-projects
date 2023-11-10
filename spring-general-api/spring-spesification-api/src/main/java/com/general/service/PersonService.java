package com.general.service;

import com.general.data.options.DataSourceLoadOptions;
import com.general.data.responseModel.LoadResult;
import com.general.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    LoadResult getAllLoad(DataSourceLoadOptions loadOptions);

    Person save(Person dto);
}
