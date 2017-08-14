package com.gemasu.volunteerWebApp.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemasu.volunteerWebApp.model.Project;

@Service
public class ProjectService {

	@Value("${webservice.url}")
	private String webserviceUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	public List<Project> getAll() {
		ResponseEntity<List<Project>> projectResponse =
		        restTemplate.exchange(webserviceUrl + "/project/",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Project>>() {
		            });
		List<Project> projects = projectResponse.getBody();
		//System.out.println("Result from Webservice: " + projects);
		return projects;
	}
}
