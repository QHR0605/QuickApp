package com.example.quickapp.entity;

import android.content.Intent;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private Boolean sex;
    private Integer age;
    private Double height;
    private Double weight;

    public User username(String username) {
        this.username = username;
        return this;
    }
    public User sex(Boolean sex) {
        this.sex = sex;
        return this;
    }
    public User age(Integer age) {
        this.age = age;
        return this;
    }
    public User height(Double height) {
        this.height = height;
        return this;
    }
    public User weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
