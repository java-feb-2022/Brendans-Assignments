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

	// finds Expense
	public Expense findExpense(Long id) {
		return expenseRepo.findById(id).orElse(null);
	}
	
	// Update expense
	public Expense updateExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
	//Delete Expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
