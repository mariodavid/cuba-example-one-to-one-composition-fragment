package com.rtcab.ceotocf.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s %s, %s %s|street,houseNumber,postcode,city")
@Table(name = "CEOTOCF_ADDRESS")
@Entity(name = "ceotocf_Address")
public class Address extends StandardEntity {
    private static final long serialVersionUID = 3368287413018623125L;

    @Column(name = "STREET")
    protected String street;

    @Column(name = "HOUSE_NUMBER")
    protected String houseNumber;

    @Column(name = "POSTCODE")
    protected String postcode;

    @Column(name = "CITY")
    protected String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}