package com.v1n1c1u.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address extends AbstractEntity<Long>{
    
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private State state;
    
    @Column(nullable = false, length = 9)
    private String postalCode;

    @Column(nullable = false, length = 5)
    private Integer number;

    private String complement;
    
    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
