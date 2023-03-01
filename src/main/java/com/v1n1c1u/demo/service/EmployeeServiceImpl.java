package com.v1n1c1u.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v1n1c1u.demo.dao.EmployeeDAO;
import com.v1n1c1u.demo.domain.Employee;

@Service @Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO dao;

    public EmployeeDAO getDao() {
        return dao;
    }

    public void setDao(EmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Employee employee) {
        dao.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        dao.update(employee);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Employee findByID(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }
    
}
