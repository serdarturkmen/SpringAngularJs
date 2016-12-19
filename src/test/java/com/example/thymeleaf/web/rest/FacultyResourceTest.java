package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.FacultyBS;
import com.example.thymeleaf.model.Department;
import com.example.thymeleaf.model.Faculty;
import com.example.thymeleaf.repository.mongo.FacultyMRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.rmi.CORBA.Util;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bawer on 14.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FacultyResourceTest {

    private MockMvc restCategoryMockMvc;

    @Autowired
    private FacultyMRepository facultyMRepository;

    @Autowired
    private FacultyBS facultyBS;

    private Faculty faculty;

    private Faculty anotherFaculty;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FacultyResource facultyResource = new FacultyResource(facultyBS);
        this.restCategoryMockMvc = MockMvcBuilders.standaloneSetup(facultyResource)
                .build();
    }

    @Before
    public void initTest() {
        faculty = new Faculty("testFaculty");
        faculty.addDepartment(new Department("testDepartment"));
        anotherFaculty = new Faculty("anotherTestFaculty");
        anotherFaculty.addDepartment(new Department("anotherTestDepartment"));
    }

    @Test
    public void list() throws Exception{
        facultyMRepository.deleteAll();
        facultyMRepository.save(faculty);
        facultyMRepository.save(anotherFaculty);
        restCategoryMockMvc.perform(get("/faculty"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$").value(hasSize(2)));
    }
}
