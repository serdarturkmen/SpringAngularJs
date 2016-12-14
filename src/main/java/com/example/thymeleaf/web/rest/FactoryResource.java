package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.BaseMongoBS;
import com.example.thymeleaf.bs.FacultyBS;
import com.example.thymeleaf.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bawer on 14.12.2016.
 */

@RestController
@RequestMapping("faculty")
public class FactoryResource extends BaseResource<Faculty>{

    private FacultyBS facultyBS;

    @Autowired
    public FactoryResource(FacultyBS facultyBS) {
        this.facultyBS = facultyBS;
    }

    @Override
    public BaseMongoBS<Faculty> getBaseMongoBS() {
        return facultyBS;
    }
}
