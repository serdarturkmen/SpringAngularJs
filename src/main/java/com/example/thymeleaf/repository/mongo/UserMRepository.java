package com.example.thymeleaf.repository.mongo;

import com.example.thymeleaf.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by bawer on 17.12.2016.
 */
public interface UserMRepository extends MongoRepository<User,String> {

    User findByEmail(String email);

    Optional<User> findOneByLogin(String login);

}
