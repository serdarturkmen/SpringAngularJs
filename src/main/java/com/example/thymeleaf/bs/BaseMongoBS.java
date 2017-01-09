package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.mon.BaseMonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by bawer on 14.12.2016.
 */
public abstract class BaseMongoBS<T extends BaseMonModel> implements IBaseMongoBS<T> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract MongoRepository<T, String > getRepository();

    @Override
    public T save(T newInstance){
        return getRepository().save(newInstance);
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> entities){
        return getRepository().save(entities);
    }

    @Override
    public T read(String id) {
        T instance = getRepository().findOne(id);
        return instance;
    }

    @Override
    public List<T> listAll() {
        return getRepository().findAll();
    }

    @Override
    public void delete(T persistentInstance) {
        getRepository().delete(persistentInstance);
    }

    @Override
    public void delete(String id) {
        getRepository().delete(id);
    }
}
