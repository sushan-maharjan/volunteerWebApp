package com.gemasu.volunteerWebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column
	private String role;
	
	public Role(){}
	
	public Role(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
