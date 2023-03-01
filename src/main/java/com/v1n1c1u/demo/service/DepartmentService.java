package com.v1n1c1u.demo.service;

import java.util.List;

import com.v1n1c1u.demo.domain.Department;

public interface DepartmentService {
    void save(Department department);

    void edit(Department department);

    void delete(Long id);

    Department findByID(Long id);

    List<Department> findAll();

    boolean departmentHasARolesAssociated(Long id);
}
