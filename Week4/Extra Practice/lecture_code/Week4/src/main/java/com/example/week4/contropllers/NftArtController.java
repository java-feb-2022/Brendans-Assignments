package com.example.week4.contropllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NftArtController {

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}
