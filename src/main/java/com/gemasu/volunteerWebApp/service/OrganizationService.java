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

import com.gemasu.volunteerWebApp.model.Organization;

@Service
public class OrganizationService {

	@Value("${webservice.url}")
	private String webserviceUrl;

	private RestTemplate restTemplate = new RestTemplate();

	public List<Organization> getOrganizations(){
		ResponseEntity<List<Organization>> response = restTemplate.exchange(webserviceUrl + "/organization/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Organization>>() {
				});
		List<Organization> organizations = response.getBody(); 
		return organizations;
	}
	
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
	public void create(Organization organization) {
		// URL
		String url = webserviceUrl + "/organization/create";
	    restTemplate.postForObject( url, organization, Organization.class);

	}
	
	public void delete(Organization organization){
		String url = webserviceUrl + "/organization/delete";
		restTemplate.delete ( url, Organization.class );
	}
	
	public void update(Organization org){
		String url = webserviceUrl + "/organization/update";
		restTemplate.put ( url, org, Organization.class);
	}
}
