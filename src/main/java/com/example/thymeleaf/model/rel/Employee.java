package com.example.thymeleaf.model.rel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by bawer on 27.12.2016.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "employee")
@Document(indexName = "employee", type="employees")
public class Employee extends BaseModel implements Serializable{

    private String name;

    private String detail;

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                "}";
    }

}
