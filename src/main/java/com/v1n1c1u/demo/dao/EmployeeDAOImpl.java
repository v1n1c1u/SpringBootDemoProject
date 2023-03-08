package com.v1n1c1u.demo.dao;

import com.v1n1c1u.demo.util.PaginationUtil;
import org.springframework.stereotype.Repository;

import com.v1n1c1u.demo.domain.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractDAO<Employee, Long> implements EmployeeDAO{

    @Override
    public List<Employee> findByName(String name) {
        return createQuery("SELECT E FROM EMPLOYEES E WHERE E.NAME LIKE CONCAT('%',?1,'%')",name);
    }

    @Override
    public List<Employee> findByRoleID(Long roleID) {
        return createQuery("SELECT E FROM EMPLOYEES E WHERE E.ROLE.ID = ?1",roleID);
    }

    @Override
    public List<Employee> findByStartAndFinishDate(LocalDate startDate, LocalDate finishDate) {
        String query = new StringBuilder(
                "SELECT E FROM EMPLOYEE E")
                .append(" WHERE E.START_DATE >= ?1 AND E.FINISH_DATE <= ?2")
                .append(" ORDER BY E.START_DATE ASC")
                .toString();

        return createQuery(
                query,
                startDate,
                finishDate);
    }

    @Override
    public List<Employee> findByStartDate(LocalDate startDate) {
        String query = new StringBuilder(
                "SELECT E FROM EMPLOYEE E")
                .append(" WHERE E.START_DATE = ?1")
                .append(" ORDER BY E.START_DATE ASC")
                .toString();

        return createQuery(
                query,
                startDate);
    }

    @Override
    public List<Employee> findByFinishDate(LocalDate finishDate) {
        String query = new StringBuilder(
                "SELECT E FROM EMPLOYEE E")
                .append(" WHERE E.FINISH_DATE = ?1")
                .append(" ORDER BY E.FINISH_DATE ASC")
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
    public long count(){
        return getEntityManager()
                .createQuery("SELECT COUNT(*) FROM Employee", Long.class)
                .getSingleResult();
    }
}
