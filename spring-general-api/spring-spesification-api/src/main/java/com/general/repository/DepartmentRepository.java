package com.general.repository;

import com.general.entity.Department;
import com.general.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaSpecificationExecutor<Department>, JpaRepository<Department, Long>, BaseRepository<Department, Long> {
}