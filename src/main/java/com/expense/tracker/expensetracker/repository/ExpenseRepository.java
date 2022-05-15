package com.expense.tracker.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.tracker.expensetracker.entity.expensetracker.Expense;
import com.expense.tracker.expensetracker.response.dto.ExpenseResponse;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	@Query("select new com.expense.tracker.expensetracker.response.dto.ExpenseResponse(ex.id,ex.expenseAmount,ex.expenseDescription,c.name,p.type) from Expense ex INNER JOIN Category c ON ex.category.id = c.id INNER JOIN PaymentType p ON  ex.payment.id = p.id where c.user.id = :userId ORDER BY ex.id desc" )
	List<ExpenseResponse> listExpense(@Param("userId") Long userId);
	
	@Query("select new com.expense.tracker.expensetracker.response.dto.ExpenseResponse(ex.id,ex.expenseAmount,ex.expenseDescription,c.name,p.type) from Expense ex INNER JOIN Category c ON ex.category.id = c.id INNER JOIN PaymentType p ON  ex.payment.id = p.id where c.user.id = :userId and c.id = :categoryId ORDER BY ex.id desc" )
	List<ExpenseResponse> listExpenseByCategory(@Param("userId") Long userId,@Param("categoryId") Long categoryId);
}
