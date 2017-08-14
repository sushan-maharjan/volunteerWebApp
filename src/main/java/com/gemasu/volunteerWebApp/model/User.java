package com.gemasu.volunteerWebApp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	private String email;
	@Column(name="hours")
	private String noOfHoursVolunteered;
	private String username;
    private String password;
    @Transient
    private String passwordConfirm;
    
    
    @OneToMany(fetch=javax.persistence.FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
    private Set<Role> roles;
    
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNoOfHoursVolunteered() {
		return noOfHoursVolunteered;
	}
	public void setNoOfHoursVolunteered(String noOfHoursVolunteered) {
		this.noOfHoursVolunteered = noOfHoursVolunteered;
	}

	
}
