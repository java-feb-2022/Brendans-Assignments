package com.codingdojo.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class MainController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id,Model model) {
		Person newPerson = personService.findPerson(person_id);
		model.addAttribute("person",newPerson);
		
		return "showPerson.jsp";
	}
}
