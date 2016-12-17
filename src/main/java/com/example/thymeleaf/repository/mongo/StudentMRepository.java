package com.example.thymeleaf.repository.mongo;

import com.example.thymeleaf.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Created by bawer on 14.12.2016.
 */
public interface StudentMRepository extends MongoRepository<Student,String > {

    Student findByFirstName(String name);
}
