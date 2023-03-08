package com.v1n1c1u.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.v1n1c1u.demo.domain.Employee;
import com.v1n1c1u.demo.util.PaginationUtil;

public interface EmployeeService {
    void save(Employee employee);

    void edit(Employee employee);

    void delete(Long id);

    Employee findByID(Long id);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    List<Employee> findByRoleID(Long roleID);

    List<Employee> findByDates(LocalDate startDate, LocalDate finishDate);

    PaginationUtil<Employee> getPagination(int currentPage, String order);
}
