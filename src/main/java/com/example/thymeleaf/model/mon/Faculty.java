package com.example.thymeleaf.model.mon;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bawer on 12.12.2016.
 */

@Data
public class Faculty extends BaseMonModel {

    public Faculty(String name){
        this.name = name;
    }

    private String name;

    private Set<Department> departments = new HashSet<>();

    public void addDepartment(Department department){
        this.departments.add(department);
    }


}
