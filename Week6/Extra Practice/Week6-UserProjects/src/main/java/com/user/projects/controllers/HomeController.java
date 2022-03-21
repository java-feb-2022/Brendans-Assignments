package com.user.projects.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.projects.models.LoginUser;
import com.user.projects.models.Project;
import com.user.projects.models.User;
import com.user.projects.services.ProjectService;
import com.user.projects.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectServ;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user, @ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}

// ************Register a User***************
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
			BindingResult result, HttpSession session, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
//		Validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			 
	            List<FieldError> fieldErrors = result.getFieldErrors();
	            for (FieldError error : fieldErrors ) {
	                System.out.print(error.getDefaultMessage());
	              } 
			System.out.println();
			return "index.jsp";
		}
//		Register User
		userService.registerUser(user);
//		Put User in Session
		session.setAttribute("loggedInUser", user);
		return "redirect:/dashboard";
	}

//******************Login********************
	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser loginuser, 
			BindingResult results, 
			HttpSession session,  
			@ModelAttribute("newUser") User user) {
		// Authenticate User
		userService.authenticateUser(loginuser, results);
		if(results.hasErrors()) {
			return "index.jsp";
		}
		User loggedInUser=userService.findByEmail(loginuser.getEmail());
		// Put User in Session
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/dashboard";
	}

//****************Logout*********************
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

//	 **********************Project Routes************************* 
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
//		Check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			User user =(User)session.getAttribute("loggedInUser");
			User userLiked = userService.findById(user.getId());
			model.addAttribute("userLiked",userLiked);
			model.addAttribute("projects", projectServ.allProjects());
			return "dashboard.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	@GetMapping("/new")
	public String newProject(@ModelAttribute("newProject") Project project, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			return "new.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/projects/create")
	public String createProject(@Valid @ModelAttribute("newProject") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			projectServ.createProject(project);
			return "redirect:/dashboard";
		}
	}
	
	
	// Project details
	@GetMapping("/projects/projectDetails/{id}")
	public String projectDetails(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Project project = projectServ.getOneProject(id);
			model.addAttribute("project",project);
			return "projectDetails.jsp";			
		} else {
			return "redirect:/";
		}
	}
	
//	@GetMapping("/projects/delete/{id}")
//	public String deleteProject(@PathVariable("id") Long id) {
//		projectServ.deleteProject(id);
//		return "redirect:/dashboard";
//	}
	// Show edit page
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Project editProject = projectServ.getOneProject(id);
			model.addAttribute("editProject", editProject);
			return "edit.jsp";
		} else {
			return "redirect:/";
		}
	}
	// Mapping for updated info from edit page
	@PutMapping("/projects/update/{id}")
	public String updateProject(@ModelAttribute("editProject") Project updateProject) {
		projectServ.updateProject(updateProject);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		projectServ.deleteProject(id);
		return "redirect:/dashboard";
	}
	
	// Like project
	@GetMapping("/project/{id}/like")
	public String likeProject(@PathVariable("id") Long id, HttpSession session) {
		Project project = projectServ.getOneProject(id);
		User user =(User)session.getAttribute("loggedInUser");
		User userLiked = userService.findById(user.getId());
		projectServ.likeProject(project, userLiked);
		return "redirect:/dashboard";
	}
	
	// Unlike
	@GetMapping("/project/{id}/unlike")
	public String unlikeProject(@PathVariable("id") Long id, HttpSession session) {
		Project project = projectServ.getOneProject(id);
		User user =(User)session.getAttribute("loggedInUser");
		User userUnliked = userService.findById(user.getId());
		projectServ.unlikeProject(project, userUnliked);
		return "redirect:/dashboard";
	}
}

