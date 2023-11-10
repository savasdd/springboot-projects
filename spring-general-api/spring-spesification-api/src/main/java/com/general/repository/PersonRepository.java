package com.general.repository;

import com.general.entity.Person;
import com.general.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaSpecificationExecutor<Person>, JpaRepository<Person, Long>, BaseRepository<Person, Long> {
}
