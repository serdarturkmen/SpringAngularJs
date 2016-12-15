package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.Faculty;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
public interface IFacultyBS extends IBaseMongoBS<Faculty> {

    Faculty read(String id);

    void delete(String id);

    List<Faculty> listAll();

    Faculty findByName(String name);
}
