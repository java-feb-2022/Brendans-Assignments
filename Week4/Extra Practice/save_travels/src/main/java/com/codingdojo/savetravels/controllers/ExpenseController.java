package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses",expenseService.getAllExpenses());
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
}
