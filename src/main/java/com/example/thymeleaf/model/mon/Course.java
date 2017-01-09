package com.example.thymeleaf.model.mon;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
@Data
public class Course extends BaseMonModel{

    public Course(String name, int capacity, Semester semester, String departmentId) {
        this.name = name;
        this.capacity = capacity;
        this.semester = semester;
        this.departmentId = departmentId;
    }

    private String name;

    private int capacity;

    private Semester semester;

    private List<Student> students = new ArrayList();

    private String departmentId;

    public void addStudent(Student student){
        this.students.add(student);
    }

}
