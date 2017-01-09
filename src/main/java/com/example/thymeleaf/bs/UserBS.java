package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.mon.User;
import com.example.thymeleaf.repository.mongo.UserMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


/**
 * Created by bawer on 14.12.2016.
 */
@Service
public class UserBS extends BaseMongoBS<User> implements IUserBS {

    private UserMRepository userMRepository;

    @Autowired
    public UserBS(UserMRepository userMRepository) {
        this.userMRepository = userMRepository;
    }

    @Override
    protected MongoRepository<User, String> getRepository() {
        return userMRepository;
    }

}
