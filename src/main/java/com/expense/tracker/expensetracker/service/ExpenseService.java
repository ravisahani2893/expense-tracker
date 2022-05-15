package com.expense.tracker.expensetracker.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(ExpenseService.class);
	
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
	
	public List<ExpenseResponse> list(UserDetails userDetails,String fromDate, String toDate){
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		if(fromDate != null && toDate != null) {
			return repository.listExpenseByDate(user.getId(), fromDate, toDate); 	
		}
		
		return repository.listExpense(user.getId());
	}
	public List<ExpenseResponse> listExpenseCurrentMonth(UserDetails userDetails){
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		 LocalDate currentdate = LocalDate.now();
		 int year = currentdate.getYear();
		 int month = currentdate.getMonthValue();
		 logger.info("Month and Year {} {}" ,month,year);
		return repository.listExpenseCurrentMonth(user.getId(),month,year);
	}
	
	public List<ExpenseResponse> listExpenseByCategory(UserDetails userDetails,Long categoryId,String fromDate, String toDate){
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		if(fromDate != null && toDate != null) {
			return repository.listExpenseByCategoryAndDate(user.getId(),categoryId, fromDate, toDate); 	
		}
		
		return repository.listExpenseByCategory(user.getId(),categoryId);
	}
	
	public List<ExpenseResponse> listExpenseCurrentMonthByCategory(UserDetails userDetails,Long categoryId){
		User user= userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		 LocalDate currentdate = LocalDate.now();
		 int year = currentdate.getYear();
		 int month = currentdate.getMonthValue();
		 logger.info("Month and Year {} {}" ,month,year);
		return repository.listExpenseCurrentMonthByCategory(user.getId(),categoryId,month,year);
	}


}
