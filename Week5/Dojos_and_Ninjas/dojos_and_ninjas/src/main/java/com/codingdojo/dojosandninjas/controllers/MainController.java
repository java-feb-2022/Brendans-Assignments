package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.getAll();
		model.addAttribute("allDojos",allDojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo",dojoService.findDojo(id));
		return "showDojo.jsp";
	}
}
