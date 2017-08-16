package com.gemasu.volunteerWebApp.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gemasu.volunteerWebApp.model.Activity;
import com.gemasu.volunteerWebApp.model.Organization;
import com.gemasu.volunteerWebApp.model.Project;
import com.gemasu.volunteerWebApp.service.ActivityService;
import com.gemasu.volunteerWebApp.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ActivityService activityService;
	
	/*
	 * 
	 */
	@RequestMapping("/list")
	public String getAll(Model model){
		model.addAttribute("projects", projectService.getAll());
		return "projectList";
	}
	
	
	@RequestMapping("/")
	public String DisplayAllProject(Model model){
		model.addAttribute("projects", projectService.getAll());
		return "home";
	}
	/*
	 * 
	 */
	
	@RequestMapping("/edit/{id}")
	public String getOne(Model model, @PathVariable int id){
		//Get all organizations
		List<Organization> organizations = projectService.getOrganizations();
		model.addAttribute("listOrganizations", organizations);

		model.addAttribute("action", "create");
		model.addAttribute("title", "Update");
		//Retrieve organization
		model.addAttribute("project",projectService.getOne(id));
		return "project";
	}
	
	@RequestMapping("/new")
	public String newProject(Model model, Project project){
		//Get all organizations
		List<Organization> organizations = projectService.getOrganizations();
		model.addAttribute("listOrganizations", organizations);
		model.addAttribute("project", project);
		model.addAttribute("action", "create");
		model.addAttribute("title", "Create");
		return "project";
	}
	
	@RequestMapping("/create")
	@PostMapping
	
	public String create(Model model, Project project, @RequestParam("organizationId") Integer organizationId){
		Organization org = projectService.getOrganization(organizationId);
		project.setOrganization(org);
		projectService.create(project);
		return "redirect:/project/list";
	}
	
	/*
	 * 
	 */

	@RequestMapping("/add_activity/{id}")
	public String showActivity(Model model, @PathVariable int id, Activity activity){
		model.addAttribute("activity",activity);
		//Retrieve project
		model.addAttribute("project",projectService.getOne(id));
		//Retrieve activities of the project
		model.addAttribute("activities",activityService.getActivityByProject(id));
		return "projectActivity";
	}
	
	@RequestMapping("/public/getactivites/{id}")
	public String getActivities(Model model, @PathVariable int id, Activity activity){
		model.addAttribute("activity",activity);
		//Retrieve project
		model.addAttribute("project",projectService.getOne(id));
		//Retrieve activities of the project
		model.addAttribute("activities",activityService.getActivityByProject(id));
		return "activities";
	}
		
	@RequestMapping("/public/{id}")
	public String getaProject(Model model, @PathVariable int id){
		/*System.out.println("ID: " + id);
		model.addAttribute("action", "register");
		model.addAttribute("title", "Apply");*/
		model.addAttribute("project",projectService.getOne(id));
		
		
		System.out.println("redirecting to projectDetail.html");
		return "projectDetailNew";
	}
	@PreAuthorize("hasRole('MEMBER')")
	@RequestMapping("/success/{id}")
	public String successful(Model model, @PathVariable int id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		projectService.addUserToProject(id, userName);
		
		//Person person = personService.findById(personService.findByEmail(userName).get(0).getId());
		
		return "SuccessfulApplication";
	}
}




