package com.v1n1c1u.demo.domain;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AbstractEntity<Long>{

    @NotBlank(message = "Inform a name")
    @Size(min=3, max=60, message = "The department name must have between {min} and {max} characters")
    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "name="+name;
    }
}
