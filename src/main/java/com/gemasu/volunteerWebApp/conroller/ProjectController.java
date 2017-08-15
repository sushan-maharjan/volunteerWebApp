package com.gemasu.volunteerWebApp.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gemasu.volunteerWebApp.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/")
	public String getAll(Model model){
		model.addAttribute("projects", projectService.getAll());
		return "projectList";
	}
	
	@RequestMapping("/edit/{id}")
	public String getAll(Model model, @PathVariable int id){
		System.out.println("ID: " + id);
		model.addAttribute("action", "update");
		model.addAttribute("title", "Update");
		model.addAttribute("project",projectService.getOne(id));
		return "project";
	}
}




