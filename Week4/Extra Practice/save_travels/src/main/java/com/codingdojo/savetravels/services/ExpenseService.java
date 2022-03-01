package com.codingdojo.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
	// Get All
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}
	
	// Create Expense
	public Expense createExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
}
