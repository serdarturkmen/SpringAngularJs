package com.example.thymeleaf.security;

import com.example.thymeleaf.repository.mongo.UserMRepository;
import com.example.thymeleaf.model.mon.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Authenticate a user from the database.
 * @author Serdar Turkmen
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserMRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Authenticating {}", email);
        String lowercaseLogin = email.toLowerCase(Locale.ENGLISH);
        User userFromDatabase = userRepository.findByEmail(email);
        if (!userFromDatabase.isEnabled()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        return userFromDatabase;
    }
}
