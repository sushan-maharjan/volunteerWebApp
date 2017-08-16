package com.gemasu.volunteerWebApp.conroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gemasu.volunteerWebApp.service.ProjectService;
import com.gemasu.volunteerWebApp.service.UserService;
@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model){
		model.addAttribute("projects", projectService.getAll());
		return "home";

	}

	
	@GetMapping("/addProject")
	public String addProject(){
		return "addProject";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginError")
	public String loginError(Model model){
		model.addAttribute("loginError", true);
		return "login";
	}
	
	
}
