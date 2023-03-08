package com.v1n1c1u.demo.dao;

import java.util.List;

import com.v1n1c1u.demo.domain.Role;
import com.v1n1c1u.demo.util.PaginationUtil;

public interface RoleDAO {
    public void save(Role entity);
	
	public void update(Role entity);
	
	public void delete(Long id);
	
	public Role findById(Long id);
	
	public List<Role> findAll();

	PaginationUtil<Role> getPagination(int page, String order);
}
