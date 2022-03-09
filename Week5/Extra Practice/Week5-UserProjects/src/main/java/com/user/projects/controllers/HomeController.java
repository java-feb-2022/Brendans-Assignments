package com.user.projects.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.projects.models.LoginUser;
import com.user.projects.models.User;
import com.user.projects.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User user, @ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}

// ************Register a User***************
	@PostMapping("/registration")
	public String registerUser() {
//		Validate user
//		Register User
//		Put User in Session
		return "redirect:/dashboard";
	}

//******************Login********************
	@PostMapping("/login")
	public String loginUser() {
		// Authenticate User
		// Put User in Session
		return "redirect:/dashboard";
	}

//****************Logout*********************
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
//		Check if user is in session
			return "dashboard.jsp";
	}

}
