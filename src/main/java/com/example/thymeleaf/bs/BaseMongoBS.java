package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.BaseMonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
public abstract class BaseMongoBS<T extends BaseMonModel> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract MongoRepository<T, String > getRepository();

    public T save(T newInstance){
        return getRepository().save(newInstance);
    }

    public <S extends T> List<S> save(Iterable<S> entities){
        return getRepository().save(entities);
    }

    public T read(String id) {
        T instance = getRepository().findOne(id);
        return instance;
    }

    public List<T> listAll() {
        return getRepository().findAll();
    }

    public void delete(T persistentInstance) {
        getRepository().delete(persistentInstance);
    }

    public void delete(String id) {
        getRepository().delete(id);
    }
}
