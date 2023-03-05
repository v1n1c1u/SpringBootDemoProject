package com.v1n1c1u.demo.domain;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractEntity<Long>{

    @NotBlank
    @Size(max = 255, min = 3)
    @Column(name = "Name", nullable = false)
    private String name;

    @NotNull
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "Salary", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salary;

    @NotNull
    @PastOrPresent(message = "{PastOrPresent.employee.startDate}")
    @DateTimeFormat(iso = ISO.DATE, pattern = "")
    @Column(name = "Start_Date", nullable = false, columnDefinition = "DATE")
    private LocalDate startDate;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "Finish_Date", nullable = true, columnDefinition = "DATE")
    private LocalDate finishDate;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id_fk")
    private Address address;

    @NotNull(message = "{NotNull.employee.role}")
    @ManyToOne
    @JoinColumn(name = "role_id_fk")
    private Role role;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", address=" + address+
                ", role=" + role +
                '}';
    }
}
