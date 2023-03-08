package com.v1n1c1u.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.v1n1c1u.demo.domain.Employee;
import com.v1n1c1u.demo.util.PaginationUtil;

public interface EmployeeDAO {
    public void save(Employee entity);
	
	public void update(Employee entity);
	
	public void delete(Long id);
	
	public Employee findById(Long id);
	
	public List<Employee> findAll();

    List<Employee> findByName(String name);

	List<Employee> findByRoleID(Long roleID);

    List<Employee> findByStartAndFinishDate(LocalDate startDate, LocalDate finishDate);

	List<Employee> findByStartDate(LocalDate startDate);

	List<Employee> findByFinishDate(LocalDate finishDate);

	public PaginationUtil<Employee> getPagination(int page, String order);
}