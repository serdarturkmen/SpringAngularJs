package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.IBaseMongoBS;
import com.example.thymeleaf.bs.IFacultyBS;
import com.example.thymeleaf.model.mon.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bawer on 14.12.2016.
 */

@RestController
@RequestMapping("faculty")
public class FacultyResource extends BaseResource<Faculty>{

    private IFacultyBS facultyBS;

    @Autowired
    public FacultyResource(IFacultyBS facultyBS) {
        this.facultyBS = facultyBS;
    }


    @Override
    public IBaseMongoBS<Faculty> getBaseMongoBS() {
        return facultyBS;
    }
}
