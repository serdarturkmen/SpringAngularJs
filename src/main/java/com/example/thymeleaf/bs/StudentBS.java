package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.Student;
import com.example.thymeleaf.repository.mongo.StudentMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by bawer on 14.12.2016.
 */
@Service
public class StudentBS extends BaseMongoBS<Student> implements IStudentBS {

    private StudentMRepository studentMRepository;

    @Autowired
    public StudentBS(StudentMRepository studentMRepository) {
        this.studentMRepository = studentMRepository;
    }

    @Override
    protected MongoRepository<Student, String> getRepository() {
        return studentMRepository;
    }


    @Override
    public Student findBYFirstName(String name) {
        return studentMRepository.findByFirstName(name);
    }
}
