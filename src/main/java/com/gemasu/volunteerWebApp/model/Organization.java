package com.gemasu.volunteerWebApp.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;



@Component
public class Organization {
	private int id;
	private String name;
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<Project> projects = new ArrayList<>();
	OrganizationStatus status;
	
	public Organization() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public OrganizationStatus getStatus() {
		return status;
	}

	public void setStatus(OrganizationStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", description=" + description + ", projects=" + projects
				+ ", status=" + status + "]";
	}

	
	
	
	
}
