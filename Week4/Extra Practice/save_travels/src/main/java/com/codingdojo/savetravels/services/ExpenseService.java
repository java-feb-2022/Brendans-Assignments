package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

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

	// finds Expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// Update expense
	public Expense updateExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
}
