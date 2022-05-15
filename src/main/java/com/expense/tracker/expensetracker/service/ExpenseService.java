package com.expense.tracker.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expense.tracker.expensetracker.entity.auth.User;
import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.entity.expensetracker.Expense;
import com.expense.tracker.expensetracker.entity.expensetracker.PaymentType;
import com.expense.tracker.expensetracker.repository.CategoryRepository;
import com.expense.tracker.expensetracker.repository.ExpenseRepository;
import com.expense.tracker.expensetracker.repository.PaymentTypeRepository;
import com.expense.tracker.expensetracker.repository.UserRepository;
import com.expense.tracker.expensetracker.request.dto.ExpenseRequest;
import com.expense.tracker.expensetracker.response.dto.ExpenseResponse;

@Service
public class ExpenseService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExpenseRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	
	public Expense save(UserDetails userDetails,  ExpenseRequest request) throws Exception {
		
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		
		
		Boolean categoryExits=categoryRepository.existsByIdAndUserId(request.getCategoryId(),user.getId());
		
		Boolean paymentTypeExits=paymentTypeRepository.existsById(request.getPaymentId());
		
		
		
		if(categoryExits && paymentTypeExits){
			Category category=categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new Exception("Category not found"));
			PaymentType paymentType=paymentTypeRepository.findById(request.getPaymentId()).orElseThrow(() -> new Exception("Payment Type not found"));;
			Expense expense=new Expense();
			expense.setCategory(category);
			expense.setPayment(paymentType);
			expense.setExpenseAmount(request.getAmount());
			expense.setExpenseDescription(request.getExpenseDescription());
			return repository.save(expense);
		}
		
		return null;
	}
	
	public List<ExpenseResponse> list(UserDetails userDetails){
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		return repository.listExpense(user.getId());
	}

}
