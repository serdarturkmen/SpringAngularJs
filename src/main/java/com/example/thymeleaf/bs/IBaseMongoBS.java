package com.example.thymeleaf.bs;

import com.example.thymeleaf.model.mon.BaseMonModel;

import java.util.List;

/**
 * Created by bawer on 15.12.2016.
 */
public interface IBaseMongoBS<T extends BaseMonModel> {

    /**
     * Persist the newInstance object into Database
     *
     * @return persistent object back to client
     * */
    T save(T newInstance);

    /**
     * Persist the list of entities into Database
     *
     * @return persistent list back
     * */
    <S extends T> List<S> save(Iterable<S> entities);

    /**
     * Find the entity by its primary key
     *
     * @return the entity
     * */
    T read(String id);

    /**
     * Returns all entities in the database
     *
     * @return List of entities
     * */
    List<T> listAll();

    /** Delete a persistent object from database */
    void delete(T persistentInstance);

    /** Delete a persistent object from database by id */
    void delete(String id);

}
