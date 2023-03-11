package com.v1n1c1u.demo.dao;

import com.v1n1c1u.demo.util.PaginationUtil;
import org.springframework.stereotype.Repository;

import com.v1n1c1u.demo.domain.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractDAO<Employee, Long> implements EmployeeDAO{

    @Override
    public List<Employee> findByName(String name, int page) {
        int size = 1;
        int start = (page-1) * size;
        return getEntityManager()
                .createQuery("SELECT E FROM Employee E WHERE E.name LIKE '%"+name+"%'",Employee.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public List<Employee> findByRoleID(Long roleID) {
        return createQuery("SELECT E FROM Employee E WHERE E.role.id = ?1",roleID);
    }

    @Override
    public List<Employee> findByStartAndFinishDate(LocalDate startDate, LocalDate finishDate) {
        String query = new StringBuilder(
                "SELECT E FROM Employee E")
                .append(" WHERE E.startDate >= ?1 AND E.finishDate <= ?2")
                .append(" ORDER BY E.startDate ASC")
                .toString();

        return createQuery(
                query,
                startDate,
                finishDate);
    }

    @Override
    public List<Employee> findByStartDate(LocalDate startDate) {
        String query = new StringBuilder(
                "SELECT E FROM Employee E")
                .append(" WHERE E.startDate = ?1")
                .append(" ORDER BY E.startDate ASC")
                .toString();

        return createQuery(
                query,
                startDate);
    }

    @Override
    public List<Employee> findByFinishDate(LocalDate finishDate) {
        String query = new StringBuilder(
                "SELECT E FROM Employee E")
                .append(" WHERE E.finishDate = ?1")
                .append(" ORDER BY E.finishDate ASC")
                .toString();

        return createQuery(
                query,
                finishDate);
    }
    public PaginationUtil<Employee> getPagination(int page, String order){
        int size = 5;
        int start = (page-1) * size;
        long totalPages = (count()+(size-1))/size;
        List<Employee> employees = getEntityManager()
                .createQuery("SELECT E FROM Employee E ORDER BY E.name "+order, Employee.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();
        return new PaginationUtil<>(size, page, totalPages, employees, order);
    }

    @Override
    public PaginationUtil<Employee> getPagination(List<Employee> searchResult, int page, String order) {
        int size = 1;
        long totalPages = (searchResult.size()+(size-1))/size;
        return new PaginationUtil<>(size, page, totalPages, searchResult, order);
    }

    public long count(){
        return getEntityManager()
                .createQuery("SELECT COUNT(*) FROM Employee", Long.class)
                .getSingleResult();
    }
}
