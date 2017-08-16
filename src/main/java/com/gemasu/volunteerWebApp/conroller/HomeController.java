package com.gemasu.volunteerWebApp.conroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gemasu.volunteerWebApp.service.UserService;
@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("user", principal.getName());
		}
		return "projectList";
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
