package com.v1n1c1u.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @Override @Transactional(readOnly = true)
    public Employee findByID(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public List<Employee> findByName(String name) {
        return dao.findByName(name);
    }

    @Override @Transactional(readOnly = true)
    public List<Employee> findByRoleID(Long roleID) {return dao.findByRoleID(roleID);}

    @Override @Transactional(readOnly = true)
    public List<Employee> findByDates(LocalDate startDate, LocalDate finishDate) {
        if(startDate != null && finishDate != null){
            return dao.findByStartAndFinishDate(startDate, finishDate);
        } else if (startDate != null) {
            return dao.findByStartDate(startDate);
        } else if (finishDate != null) {
            return dao.findByFinishDate(finishDate);
        }
        return new ArrayList<>();
    }
}
