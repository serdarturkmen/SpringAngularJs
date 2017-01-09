package com.example.thymeleaf.model.mon;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by bawer on 12.12.2016.
 */

@Data
@Document
public class Student extends BaseMonModel {

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;

    private String lastName;

    private String departmentId;

    private String facultyId;

//    private List<Course> courses;

}
