package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.IBaseMongoBS;
import com.example.thymeleaf.bs.IStudentBS;
import com.example.thymeleaf.bs.MailService;
import com.example.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bawer on 15.12.2016.
 */
@RestController
@RequestMapping("student")
public class StudentResource extends BaseResource<Student>{

    private IStudentBS studentBS;

    @Autowired
    private MailService mailService;

    @Autowired
    public StudentResource(IStudentBS studentBS) {
        this.studentBS = studentBS;
    }

    @Override
    public IBaseMongoBS<Student> getBaseMongoBS() {
        return studentBS;
    }

    @RequestMapping(value = "dene", method = RequestMethod.GET)
    public String dene() throws Exception {
        if(1>0){
            mailService.sendEmail("baver_t@hotmail.com","subject", "dsadsas",false,true);
            throw new Exception();
        }
        return "ok";
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public Student getByName(@PathVariable("name") String name){
        return studentBS.findBYFirstName(name);
    }
}
