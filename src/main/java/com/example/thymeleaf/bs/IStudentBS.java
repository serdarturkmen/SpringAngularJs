package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.Student;

/**
 * Created by bawer on 14.12.2016.
 */
public interface IStudentBS {

    Student findBYFirstName(String name);
}
