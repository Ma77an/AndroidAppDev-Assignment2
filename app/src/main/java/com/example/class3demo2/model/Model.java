package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        for (int i = 0; i < 20; i++) {
            addStudent(new Student("name " + i, "" + i + i + i + i + i + i + i, "", "054" + i + i + i + i + i + i + i + i, false));
        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public Student getStudent(int pos) {
        return data.get(pos);
    }

    public void addStudent(Student st) {
        data.add(st);
    }


}
