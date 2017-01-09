package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.mon.Student;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
public interface IStudentBS extends IBaseMongoBS<Student> {

    Student findBYFirstName(String name);

    List<Student> search(String qry);
}
