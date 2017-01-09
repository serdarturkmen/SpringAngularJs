package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.mon.Student;
import com.example.thymeleaf.repository.mongo.StudentMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by bawer on 14.12.2016.
 */
@Service
public class StudentBS extends BaseMongoBS<Student> implements IStudentBS {

    private StudentMRepository studentMRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    /**
     *
     * @param qry
     * @return list<Student> by criteria
     */
    @Override
    public List<Student> search(String qry){
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(qry,qry);
        Query query = TextQuery.query(criteria);

        List<Student> students = mongoTemplate.find(query,Student.class);
        return students;
    }
}
