package com.codingdojo.omikujiforms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(HttpSession session, @RequestParam("number") Integer number, @RequestParam("city") String city, @RequestParam("person") String person, @RequestParam("hobby") String hobby, @RequestParam("living") String living, @RequestParam("nice") String nice) {
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("living", living);
			session.setAttribute("nice", nice);
		return "redirect:/show";
	}
	
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		Integer number = (Integer) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String living = (String) session.getAttribute("living");
		String nice = (String) session.getAttribute("nice");
		
		model.addAttribute("number",number);
		model.addAttribute("city",city);
		model.addAttribute("person",person);
		model.addAttribute("hobby",hobby);
		model.addAttribute("living",living);
		model.addAttribute("nice",nice);
		
		return "show.jsp";
	}
}
