package com.v1n1c1u.demo.service;

import java.util.List;

import com.v1n1c1u.demo.domain.Employee;

public interface EmployeeService {
    void save(Employee employee);

    void edit(Employee employee);

    void delete(Long id);

    Employee findByID(Long id);

    List<Employee> findAll();
}
