package com.gemasu.volunteerWebApp.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gemasu.volunteerWebApp.model.Organization;
import com.gemasu.volunteerWebApp.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;

	@RequestMapping("/list")
	public String getAll(Model model){
		//model.addAttribute(organizationService.getOrganizations());
		return "organizationList";
	}
	
	@RequestMapping("/new")
	public String newOrganization(Model model){
		model.addAttribute("action", "create");
		return "organization";
	}
	
	@PostMapping("/create")
	public String create(Organization org, Model model){
		model.addAttribute("action", "Create");
		organizationService.create(org);
		return "redirect:/organization";
	}
	
	@RequestMapping("/{id}")
	public String getDetails(@PathVariable int id, Model model){
		model.addAttribute("action", "Update");
		model.addAttribute("org", organizationService.getOrganization(id));
		return "organizationDetails";
	}
	
	@PostMapping("/{id}")
	public String update(Organization org){
		organizationService.update(org);
		return "redirect:/";
	}
}
