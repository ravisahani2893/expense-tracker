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

import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.request.dto.CategoryRequest;
import com.expense.tracker.expensetracker.response.dto.CategoryResponse;
import com.expense.tracker.expensetracker.service.CategoryService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/api/category")
	public CategoryResponse list() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return categoryService.list(userDetails);

	}
	
	@PostMapping("/api/category")
	public Category save(@Valid @RequestBody CategoryRequest categoryRequest) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return categoryService.save(userDetails, categoryRequest);
	}

}
