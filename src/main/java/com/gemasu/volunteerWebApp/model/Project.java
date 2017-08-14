package com.gemasu.volunteerWebApp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	private int id;
	private int maxNumOfMemebers;
	private String name;
	private Date StartDate;
	private Date endDate;
	private Collection<User> user = new ArrayList<User>();
	private Collection<Activity> activities = new ArrayList<Activity>();
	private Organization organization;
	private Category category;
	private Status status;

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

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}

	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getMaxNumOfMemebers() {
		return maxNumOfMemebers;
	}

	public void setMaxNumOfMemebers(int maxNumOfMemebers) {
		this.maxNumOfMemebers = maxNumOfMemebers;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Project() {
		

	}

}
