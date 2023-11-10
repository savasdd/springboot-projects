package com.general.service.impl;

import com.general.data.options.DataSourceLoadOptions;
import com.general.data.response.LoadResult;
import com.general.entity.Person;
import com.general.repository.PersonRepository;
import com.general.service.PersonService;
import com.general.data.filter.ECondition;
import com.general.data.filter.EOperator;
import com.general.data.filter.Filter;
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
    public LoadResult getAllLoad(DataSourceLoadOptions loadOptions) {
        loadOptions.setRequireTotalCount(true);
        var list = repository.load(loadOptions);

        return list;
        //return getLoadFilter(loadOptions);
    }

    @Override
    public Person save(Person dto) {
        var model = repository.save(dto);

        log.info("create person", model.getId());
        return model;
    }

    private LoadResult getLoadFilter(DataSourceLoadOptions loadOptions) {
        var filter = Filter.build(Person.class)
                .condition(ECondition.or)
                .operation(EOperator.startswith)
                .with(w -> w.getDepartment().setCode("02"));
        loadOptions.setMandatoryFilter(filter.get());

        return repository.load(loadOptions);
    }
}
