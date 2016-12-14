package com.example.thymeleaf.web.rest;

import com.example.thymeleaf.bs.BaseMongoBS;
import com.example.thymeleaf.model.BaseMonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
public abstract class BaseResource<T extends BaseMonModel> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public abstract BaseMongoBS<T> getBaseMongoBS();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<T> list() {
        return getBaseMongoBS().listAll();
    }

    @RequestMapping(value = "{eid}", method = RequestMethod.GET)
    @ResponseBody
    public T get(@PathVariable("eid") T entity) {
        return getBaseMongoBS().read(entity.getId());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public T post(@RequestBody T entity) {
        return getBaseMongoBS().save(entity);
    }

    @RequestMapping(value = "{eid}", method = RequestMethod.POST)
    @ResponseBody
    public T update(@RequestBody T entity) {
        return getBaseMongoBS().save(entity);
    }

    @RequestMapping(value = "{eid}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("eid") T entity) {
        getBaseMongoBS().delete(entity);
        return true;
    }
}
