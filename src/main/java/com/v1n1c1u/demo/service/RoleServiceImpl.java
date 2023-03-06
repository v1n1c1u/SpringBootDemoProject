package com.v1n1c1u.demo.service;

import java.util.Arrays;
import java.util.List;

import com.v1n1c1u.demo.util.PaginationUtil;
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

    @Override @Transactional(readOnly = true)
    public Role findByID(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public boolean roleHasEmployeesAssociated(Long id) {
        return findByID(id).getEmployees().isEmpty() ? false : true;
    }

    @Override
    public PaginationUtil<Role> getPagination(int page) {
        return dao.getPagination(page);
    }

}
