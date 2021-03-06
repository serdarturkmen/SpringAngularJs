package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.IBaseMongoBS;
import com.example.thymeleaf.bs.IStudentBS;
import com.example.thymeleaf.bs.MailService;
import com.example.thymeleaf.model.mon.Student;
import com.example.thymeleaf.model.rel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

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

    @RequestMapping(value = "mail", method = RequestMethod.GET)
    public String dene() throws Exception {
        if(1==1){
            throw new DataIntegrityViolationException("Duplicate id");
        }
//        mailService.sendEmail("baver_t@hotmail.com","subject", "dsadsas",false,true);
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

    /**
     * @param query the query to search
     * @return the result of the search
     */
    @RequestMapping("/_search/{query}")
    public List<Student> search(@PathVariable String query) {
        return studentBS.search(query);
    }

}
