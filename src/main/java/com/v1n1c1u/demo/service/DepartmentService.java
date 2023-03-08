package com.v1n1c1u.demo.service;

import java.util.List;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.util.PaginationUtil;

public interface DepartmentService {
    void save(Department department);

    void edit(Department department);

    void delete(Long id);

    Department findByID(Long id);

    List<Department> findAll();

    boolean departmentHasARolesAssociated(Long id);

    PaginationUtil<Department> getPagination(int page, String order);

}
