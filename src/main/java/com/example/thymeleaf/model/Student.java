package com.example.thymeleaf.model;

import lombok.Data;

import java.util.List;

/**
 * Created by bawer on 12.12.2016.
 */

@Data
public class Student extends BaseMonModel {

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;

    private String lastName;

    private String departmentId;

    private String facultyId;

    private List<Course> courses;

}
