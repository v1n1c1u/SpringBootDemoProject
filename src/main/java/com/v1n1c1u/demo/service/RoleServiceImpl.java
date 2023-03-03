package com.v1n1c1u.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v1n1c1u.demo.dao.RoleDAO;
import com.v1n1c1u.demo.domain.Role;

@Service @Transactional(readOnly = false)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO dao;

    public RoleDAO getDao() {
        return dao;
    }

    public void setDao(RoleDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public void edit(Role role) {
        dao.update(role);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Role findByID(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean roleHasEmployeesAssociated(Long id) {
        return findByID(id).getEmployees().isEmpty() ? false : true;
    }
    
}
