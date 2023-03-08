package com.v1n1c1u.demo.dao;

import com.v1n1c1u.demo.util.PaginationUtil;
import org.springframework.stereotype.Repository;

import com.v1n1c1u.demo.domain.Department;

import java.util.List;


@Repository
public class DepartmentDAOImpl extends AbstractDAO<Department, Long> implements DepartmentDAO{
    public PaginationUtil<Department> getPagination(int page, String order){
        int size = 5;
        int start = (page-1) * size;
        long totalPages = (count()+(size-1))/size;
        List<Department> departments = getEntityManager()
                .createQuery("SELECT D FROM Department D ORDER BY D.name "+order, Department.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();
        return new PaginationUtil<>(size, page, totalPages, departments,order);
    }
    public long count(){
        return getEntityManager()
                .createQuery("SELECT COUNT(*) FROM Department", Long.class)
                .getSingleResult();
    }
}
