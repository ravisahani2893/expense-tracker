package com.expense.tracker.expensetracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.expensetracker.entity.expensetracker.Expense;
import com.expense.tracker.expensetracker.request.dto.ExpenseRequest;
import com.expense.tracker.expensetracker.response.dto.ExpenseResponse;
import com.expense.tracker.expensetracker.service.ExpenseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService service;

	@PostMapping("/api/expense")
	public Expense save(@Valid @RequestBody ExpenseRequest request) throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.save(userDetails,request);
	}
	
	@GetMapping("/api/expense")
	public List<ExpenseResponse> list(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.list(userDetails);
	}
	
	

}
