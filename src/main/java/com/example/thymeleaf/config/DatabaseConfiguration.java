package com.example.thymeleaf.config;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableJpaRepositories("com.example.thymeleaf.repository.rel")
//@EnableTransactionManagement
public class DatabaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);


    /**
     * Hibernate Module Configuration for lazy loaded objects configuration
     * return id without fetching entire object
     *
     * @return 	return hibernate4Module
     */
    @Bean
    public Hibernate4Module hibernate4Module() {
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);
        return hibernate4Module;
    }

}
