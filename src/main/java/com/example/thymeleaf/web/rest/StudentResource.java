package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.IBaseMongoBS;
import com.example.thymeleaf.bs.IStudentBS;
import com.example.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bawer on 15.12.2016.
 */
@RestController
@RequestMapping("student")
public class StudentResource extends BaseResource<Student>{

    private IStudentBS studentBS;

    @Autowired
    public StudentResource(IStudentBS studentBS) {
        this.studentBS = studentBS;
    }

    @Override
    public IBaseMongoBS<Student> getBaseMongoBS() {
        return studentBS;
    }
}
