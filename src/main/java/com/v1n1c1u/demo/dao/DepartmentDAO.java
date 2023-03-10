package com.v1n1c1u.demo.dao;

import java.util.List;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.util.PaginationUtil;

public interface DepartmentDAO {
    public void save(Department entity);
	
	public void update(Department entity);
	
	public void delete(Long id);
	
	public Department findById(Long id);
	
	public List<Department> findAll();

	public PaginationUtil<Department> getPagination(int page, String order);
    
}
