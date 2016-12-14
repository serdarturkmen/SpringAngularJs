package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.Faculty;
import com.example.thymeleaf.repository.mongo.FacultyMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
@Service
public class FacultyBS extends BaseMongoBS<Faculty> implements IFacultyBS {

    private FacultyMRepository facultyMRepository;

    @Autowired
    public FacultyBS(FacultyMRepository facultyMRepository) {
        this.facultyMRepository = facultyMRepository;
    }

    @Override
    protected MongoRepository<Faculty, String> getRepository() {
        return facultyMRepository;
    }

    @Override
    public Faculty findByName(String name) {
        return facultyMRepository.findByName(name);
    }
}
