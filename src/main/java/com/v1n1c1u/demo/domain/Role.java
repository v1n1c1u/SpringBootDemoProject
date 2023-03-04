package com.v1n1c1u.demo.domain;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ROLES")
public class Role extends AbstractEntity<Long>{

    @NotBlank(message = "Inform a name")
    @Size(min=3, max=60, message = "The role name must have between {min} and {max} characters")
    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_department_fk")
    private Department department;

    @OneToMany(mappedBy = "role")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
