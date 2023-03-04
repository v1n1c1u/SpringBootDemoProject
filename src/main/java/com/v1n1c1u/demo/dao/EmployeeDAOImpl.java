package com.v1n1c1u.demo.dao;

import jakarta.persistence.TypedQuery;
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
}
