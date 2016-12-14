package com.example.thymeleaf.repository.mongo;

import com.example.thymeleaf.model.Faculty;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by bawer on 14.12.2016.
 */
public interface FacultyMRepository extends MongoRepository<Faculty, String > {

    Faculty findByName(String name);
}
