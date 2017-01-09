package com.example.thymeleaf.model.rel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author bawer
 *
 * Base class for supports id for other classses
 */

@MappedSuperclass
public class BaseModel {
	

	public BaseModel() {
		super();
	}

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	private Date createdDate;
//	
//	private Date updatedDate;

}
