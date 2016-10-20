package com.arksh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
@Entity
public class Address implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    private Integer personId;

    @Column(length = 50)
    private String province;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String country;

    public Address() {
    }

    public Address(Integer personId, String province, String city, String country) {
        this.personId = personId;
        this.province = province;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
