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

import com.gemasu.volunteerWebApp.model.Project;

@Service
public class ProjectService {

	@Value("${webservice.url}")
	private String webserviceUrl;

	private RestTemplate restTemplate = new RestTemplate();

	public List<Project> getAll() {
		ResponseEntity<List<Project>> projectResponse = restTemplate.exchange(webserviceUrl + "/project/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Project>>() {
				});
		List<Project> projects = projectResponse.getBody();
		// System.out.println("Result from Webservice: " + projects);
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
		webserviceUrl = webserviceUrl + "/project/{projectId}";

		// URL Parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("projectId", id.toString());

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(webserviceUrl);

		System.out.println(builder.buildAndExpand(uriParams).toUri());

		ResponseEntity<Project> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Project>() {
				});

		Project project = response.getBody();
		return project;
	}

	public void create(Project project) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(webserviceUrl + "/project/").queryParam("id",
				project.getId());

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Project> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<Project>() {
				});

		// Project project = response.getBody();
		// System.out.println("Result from Webservice: " + projects);

	}
}
