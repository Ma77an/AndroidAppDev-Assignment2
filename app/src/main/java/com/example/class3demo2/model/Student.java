package com.example.class3demo2.model;

public class Student {
    public String name;
    public String id;
    public String avatarUrl;
    public String phone;
    public Boolean cb;

    public Student(String name, String id, String avatarUrl, String phone, Boolean cb) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.cb = cb;
    }
}
