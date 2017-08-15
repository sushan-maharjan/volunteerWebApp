package com.gemasu.volunteerWebApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gemasu.volunteerWebApp.model.Activity;
import com.gemasu.volunteerWebApp.model.Organization;
import com.gemasu.volunteerWebApp.model.Project;

@Service
public class ActivityService {

	@Value("${webservice.url}")
	private String webserviceUrl;

	private RestTemplate restTemplate = new RestTemplate();

	/*
	 * 
	 */
	public List<Activity> getActivityByProject(Integer id) {
		// URL
		String url = webserviceUrl + "/activity/projectactivity/{id_project}";

		// URL Parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id_project", id.toString());
		
		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		
		// Call
		ResponseEntity<List<Activity>> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Activity>>() {
				});

		List<Activity> activities = response.getBody();
		return activities;
	}
	
	/*
	 * 
	 */
	public void create(Activity activity) {
		// URL
		String url = webserviceUrl + "/activity/create";
		restTemplate.postForObject( url, activity, Activity.class);
	}
	
	/*
	 * 
	 */
	public void deleteById(Integer id) {
		// URL
		String url = webserviceUrl + "/activity/delete/{id_activity}";

		// URL Parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id_activity", id.toString());
		
		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		
		// Call
		restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), 
				HttpMethod.GET, 
				null,
				Void.class);

	}
}
