package com.expense.tracker.expensetracker.response.dto;

import java.util.List;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;

public class CategoryResponse {

	private Long userId;
	private List<Category> categories;
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
