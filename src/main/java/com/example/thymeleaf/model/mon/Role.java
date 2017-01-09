package com.example.thymeleaf.model.mon;

import org.springframework.security.core.GrantedAuthority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

public class Role extends BaseMonModel implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	private String name;

	public Role() {
	}
	
	public Role(String id){
		setId(id);
	}

	@JsonIgnore
	@Override
	public String getAuthority() {
		return getName();
	}

}
