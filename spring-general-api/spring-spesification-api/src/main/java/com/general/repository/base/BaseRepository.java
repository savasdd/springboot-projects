package com.general.repository.base;

import com.general.data.options.DataSourceLoadOptionsBase;
import com.general.data.responseModel.LoadResult;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    LoadResult load(DataSourceLoadOptionsBase options);

    LoadResult loadTuple(DataSourceLoadOptionsBase options);

    LoadResult loadEntity(DataSourceLoadOptionsBase options);

    String getSqlQuery(DataSourceLoadOptionsBase options);
}
