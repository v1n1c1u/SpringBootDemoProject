package com.v1n1c1u.demo.dao;

import com.v1n1c1u.demo.util.PaginationUtil;
import org.springframework.stereotype.Repository;

import com.v1n1c1u.demo.domain.Role;

import java.util.List;


@Repository
public class RoleDAOImpl extends AbstractDAO<Role, Long> implements RoleDAO{

    public PaginationUtil<Role> getPagination(int page){
        int size = 5;
        int start = (page-1) * size;
        long totalPages = (count()+(size-1))/size;
        List<Role> roles = getEntityManager()
                .createQuery("SELECT R FROM ROLES R ORDER BY R.NAME ASC", Role.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();
        return new PaginationUtil<>(size, page, totalPages, roles);
    }
    public long count(){
        return getEntityManager()
                .createQuery("SELECT COUNT(*) FROM ROLES", Long.class)
                .getSingleResult();
    }
}
