package com.expense.tracker.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
}
