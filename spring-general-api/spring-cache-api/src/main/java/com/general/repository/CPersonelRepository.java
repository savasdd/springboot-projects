package com.general.repository;

import com.general.dao.CPersonel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CPersonelRepository extends JpaRepository<CPersonel,Long> {

    @Query("select v from CPersonel v group by v.name order by v.name")
    List<CPersonel> getAll();

}
