package com.gemasu.volunteerWebApp.model;

import org.springframework.stereotype.Component;

@Component
public class Activity {
	public int id;
	public Project project;
	private String name;

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", project=" + project + ", name=" + name + "]";
	}

	public Activity() {
		
	}
	

}
