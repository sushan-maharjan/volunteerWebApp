package com.gemasu.volunteerWebApp.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gemasu.volunteerWebApp.model.Activity;
import com.gemasu.volunteerWebApp.service.ActivityService;
import com.gemasu.volunteerWebApp.service.ProjectService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	ActivityService activityService;
	
	@Autowired
	ProjectService projectService;
	
	/*
	 * 
	 */
	@RequestMapping("/create")
	public String create(@RequestParam("name") String name, 
				@RequestParam("id") int projectId) {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setProject(projectService.getOne(projectId));
		System.out.println("Activity: " + activity);
		activityService.create(activity);
		return "redirect:/project/list";
	}
	
	@RequestMapping("/delete/{id_activity}/project/{id_project}")
	public String create(@PathVariable("id_activity") int activityId, 
						@PathVariable("id_project") int projectId) {
		activityService.deleteById(activityId);
		return "redirect:/project/add_activity/" + projectId;
	}
	
}
