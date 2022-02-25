package com.codingdojo.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0); 
			return "index.jsp";
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount + 1);
			return "index.jsp";
		}
	}
		
	@RequestMapping("/counter") 
	public String counter(HttpSession session, Model model) {
		Integer showCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow",showCount);
		return "counter.jsp";
	}
	
	
}

