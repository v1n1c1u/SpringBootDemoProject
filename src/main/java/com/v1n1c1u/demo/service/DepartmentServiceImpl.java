package com.v1n1c1u.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v1n1c1u.demo.dao.DepartmentDAO;
import com.v1n1c1u.demo.domain.Department;


@Service @Transactional(readOnly = false)
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDAO dao;

    public DepartmentDAO getDao() {
        return dao;
    }

    public void setDao(DepartmentDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Department department) {
        dao.save(department);
    }

    @Override
    public void edit(Department department) {
        dao.update(department);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Department findByID(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Department> findAll() {
        return dao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public boolean departmentHasARolesAssociated(Long id) {
        return findByID(id).getRoles().isEmpty() ? false : true;
    }
    
}
