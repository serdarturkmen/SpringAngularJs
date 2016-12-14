package com.example.thymeleaf.model;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bawer on 12.12.2016.
 */

@Data
public class Department extends BaseMonModel {

    public Department(String name) {
        this.name = name;
    }

    private String name;

    private Set<Student> students = new HashSet<>();

    private Set<Course> courses = new HashSet<>();

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

}
