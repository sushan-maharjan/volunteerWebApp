package com.gemasu.volunteerWebApp.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gemasu.volunteerWebApp.model.Organization;
import com.gemasu.volunteerWebApp.model.Project;

@Service
public class ProjectService {

	@Value("${webservice.url}")
	private String webserviceUrl;

	private RestTemplate restTemplate = new RestTemplate();

	/*
	 * **********************This belongs to organizationService
	 */
	public List<Organization> getOrganizations(){
		ResponseEntity<List<Organization>> response = restTemplate.exchange(webserviceUrl + "/organization/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Organization>>() {
				});
		List<Organization> organizations = response.getBody(); 
		return organizations;
	}
	
	/*
	 * **********************This belongs to organizationService
	 */
	public Organization getOrganization(Integer id) {
		// URL
		String url = webserviceUrl + "/organization/{id}";

		// URL Parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id", id.toString());

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		//System.out.println(builder.buildAndExpand(uriParams).toUri());

		ResponseEntity<Organization> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Organization>() {
				});

		Organization organization = response.getBody();
		return organization;
	}
	
	/*
	 * Get All projects
	 * 
	 * @Return	Collection of projects
	 */
	public List<Project> getAll() {
		ResponseEntity<List<Project>> projectResponse = restTemplate.exchange(webserviceUrl + "/project/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Project>>() {
				});
		List<Project> projects = projectResponse.getBody();
		return projects;
	}

	/*
	 * Get project object by id
	 * 
	 * @Param	id	Integer Project id
	 * @Return	Project Object
	 */
	public Project getOne(Integer id) {
		// URL
		String url = webserviceUrl + "/project/{id_project}";

		// URL Parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id_project", id.toString());

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		//System.out.println(builder.buildAndExpand(uriParams).toUri());

		ResponseEntity<Project> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Project>() {
				});

		Project project = response.getBody();
		return project;
	}

	/*
	 * Create a New Project
	 * 
	 * @Param	id	Integer Project id
	 * @Return	Project Object
	 */
	public void create(Project project) {
		// URL
		String url = webserviceUrl + "/project/create";
	    restTemplate.postForObject( url, project, Project.class);

	}
}
