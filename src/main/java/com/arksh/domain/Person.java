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
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer age;

    @Column(length = 20)
    private String name;

    private Integer addressId;

    public Person() {
    }

    public Person(Integer age, String name, Integer addressId) {
        this.age = age;
        this.name = name;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
