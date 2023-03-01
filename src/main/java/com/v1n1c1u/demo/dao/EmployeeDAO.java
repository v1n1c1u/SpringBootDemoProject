package com.v1n1c1u.demo.dao;

import java.util.List;

import com.v1n1c1u.demo.domain.Employee;

public interface EmployeeDAO {
    public void save(Employee entity);
	
	public void update(Employee entity);
	
	public void delete(Long id);
	
	public Employee findById(Long id);
	
	public List<Employee> findAll();
}