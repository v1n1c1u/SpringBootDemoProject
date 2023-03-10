package com.v1n1c1u.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "ADDRESSES")
public class Address extends AbstractEntity<Long>{

    @NotBlank
    @Size(min=3,max=255)
    @Column(nullable = false)
    private String address;

    @NotBlank
    @Size(min=3,max=255)
    @Column(nullable = false)
    private String city;

    @NotNull(message = "{NotNull.address.state}")
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private State state;

    @NotBlank
    @Size(min = 9,max = 9, message = "{Size.address.postalCode}")
    @Column(nullable = false, length = 9)
    private String postalCode;

    @NotNull(message = "{NotNull.address.number}")
    @Digits(integer = 5, fraction = 0)
    @Column(nullable = false, length = 5)
    private Integer number;

    @Size(max = 255)
    @Column(nullable = true)
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

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state.getAcronym() +
                ", postalCode='" + postalCode + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                '}';
    }
}
