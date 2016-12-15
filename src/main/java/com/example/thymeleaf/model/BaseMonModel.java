package com.example.thymeleaf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * base model with string id
 */

@MappedSuperclass
public class BaseMonModel {


	public BaseMonModel() {
		setId(UUID.randomUUID().toString());
		setCreatedDate(new Date());
	}

	public BaseMonModel(String id) {
		this.setId(id);
	}

	/**
	 * set id
	 */
	@Id
	@Getter
	@Setter
	private String id;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedDate", updatable = false)
	@Getter
	@Setter
	protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdatedDate")
	@Getter
	@Setter
	private Date updatedDate;

	@PrePersist
	protected void onCreate() {
		Date now = new Date();
		setCreatedDate(now);
	}

	@PreUpdate
	protected void onUpdate() {
		Date now = new Date();
		setUpdatedDate(now);
	}

}
