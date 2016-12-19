package com.example.thymeleaf.model;

import java.util.*;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class User extends BaseMonModel implements UserDetails {

	private static final long serialVersionUID = 1L;

	public User() {
	}

	private String password;
	
	@Getter
	@Setter
    private String firstName;

    @Getter
	@Setter
    private String lastName;

	@Getter
	@Setter
	@JsonIgnore
	private String salt;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private Set<Role> roles = new HashSet<>();

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@Getter
	@Setter
	private boolean enabled;

	@Getter
	@Setter
	private Date lastLogin;

	@Getter
	@Pattern(regexp ="^[_'.@A-Za-z0-9-]*$")
	private String login;

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return getEmail();
	}

	public boolean hasRole(String role) {
		for (Role r : getRoles()) {
			if (role.equals(r.getName())) {
				return true;
			}
		}
		return false;
	}

	//Lowercase the login before saving it in database
	public void setLogin(String login) {
		this.login = login.toLowerCase(Locale.ENGLISH);
	}

}
