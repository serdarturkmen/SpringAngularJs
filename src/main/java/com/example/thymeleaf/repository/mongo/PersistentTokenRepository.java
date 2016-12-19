package com.example.thymeleaf.repository.mongo;

import com.example.thymeleaf.model.PersistentToken;
import com.example.thymeleaf.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersistentTokenRepository extends MongoRepository<PersistentToken, String> {

    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);

}