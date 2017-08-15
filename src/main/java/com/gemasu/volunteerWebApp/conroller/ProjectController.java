package com.gemasu.volunteerWebApp.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gemasu.volunteerWebApp.model.Organization;
import com.gemasu.volunteerWebApp.model.Project;
import com.gemasu.volunteerWebApp.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/list")
	public String getAll(Model model){
		model.addAttribute("projects", projectService.getAll());
		return "projectList";
	}
	
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
}
