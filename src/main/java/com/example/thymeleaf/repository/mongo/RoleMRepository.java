package com.example.thymeleaf.repository.mongo;

import com.example.thymeleaf.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by bawer on 17.12.2016.
 */
public interface RoleMRepository extends MongoRepository<Role, String> {
}
