package com.codingdojo.StaticPractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
	// ...
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	// ...

}
