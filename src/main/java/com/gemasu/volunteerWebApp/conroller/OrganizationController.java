package com.gemasu.volunteerWebApp.conroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("organizations", organizationService.getOrganizations());
		return "organizationList";
	}
	
	@RequestMapping("/new")
	public String newOrganization(Model model, Organization organization){
		model.addAttribute("action", "create");
		return "organization";
	}
	
	@PostMapping("/create")
	public String create(@Valid Organization organization, Model model){
		model.addAttribute("action", "Create");
		organizationService.create(organization);
		return "redirect:/organization/list";
	}
	
	@RequestMapping("/{id}")
	public String getDetails(@PathVariable int id, Model model){
		model.addAttribute("action", "update");
		model.addAttribute("organization", organizationService.getOrganization(id));
		return "organization";
	}
	
	@PostMapping("/update")
	public String update(Organization org){
		organizationService.update(org);
		return "redirect:/organization/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		organizationService.delete(organizationService.getOrganization(id));
		return "redirect:/organization/list";
	}
}
