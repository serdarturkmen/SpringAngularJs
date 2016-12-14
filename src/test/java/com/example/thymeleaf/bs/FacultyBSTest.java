package com.example.thymeleaf.bs;

import static org.junit.Assert.assertEquals;
import com.example.thymeleaf.model.Department;
import com.example.thymeleaf.model.Faculty;
import com.example.thymeleaf.repository.mongo.FacultyMRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bawer on 14.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FacultyBSTest {

    @Autowired
    private FacultyMRepository facultyMRepository;

    @Autowired
    private IFacultyBS facultyBS;

    private Faculty faculty;
    private Faculty anotherFaculty;

    @Before
    public void initTest(){
        facultyMRepository.deleteAll();
        faculty = new Faculty("testFaculty");
        faculty.addDepartment(new Department("testDepartment"));
        anotherFaculty = new Faculty("anotherTestFaculty");
        anotherFaculty.addDepartment(new Department("anotherTestDepartment"));
    }

    @Test
    public void read() throws Exception {
        Faculty fac = facultyMRepository.save(faculty);
        assertEquals(faculty.getName(), facultyBS.read(fac.getId()).getName());
    }

    @Test
    public void findByName() throws Exception {
        facultyMRepository.save(faculty);
        assertEquals(faculty.getName(), facultyBS.findByName(faculty.getName()).getName());
    }

    @Test
    public void delete() throws Exception {
        facultyMRepository.save(faculty);
        long count = facultyMRepository.count();
        facultyBS.delete(faculty.getId());
        long countAfter = facultyMRepository.count();
        assertEquals(count - 1, countAfter);
    }

    public void listAll() throws Exception{
        facultyMRepository.save(faculty);
        facultyMRepository.save(anotherFaculty);
        assertEquals(2, facultyBS.listAll().size());
    }
}
