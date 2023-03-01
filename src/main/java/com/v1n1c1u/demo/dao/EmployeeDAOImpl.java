package com.v1n1c1u.demo.dao;

import org.springframework.stereotype.Repository;

import com.v1n1c1u.demo.domain.Employee;

@Repository
public class EmployeeDAOImpl extends AbstractDAO<Employee, Long> implements EmployeeDAO{
    
}
