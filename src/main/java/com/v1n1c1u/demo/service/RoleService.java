package com.v1n1c1u.demo.service;

import java.util.List;

import com.v1n1c1u.demo.domain.Role;

public interface RoleService {
    void save(Role role);

    void edit(Role role);

    void delete(Long id);

    Role findByID(Long id);

    List<Role> findAll();

    boolean roleHasEmployeesAssociated(Long id);
}
