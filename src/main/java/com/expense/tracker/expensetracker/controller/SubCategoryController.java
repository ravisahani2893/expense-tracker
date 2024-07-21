package com.expense.tracker.expensetracker.controller;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.entity.expensetracker.SubCategory;
import com.expense.tracker.expensetracker.request.dto.CategoryRequest;
import com.expense.tracker.expensetracker.request.dto.SubCategoryRequest;
import com.expense.tracker.expensetracker.response.dto.CategoryResponse;
import com.expense.tracker.expensetracker.response.dto.SubCategoryResponse;
import com.expense.tracker.expensetracker.service.CategoryService;
import com.expense.tracker.expensetracker.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class SubCategoryController {
	@Autowired
	private SubCategoryService subCategoryService;

	@GetMapping("/api/subcategory")
	public List<SubCategoryResponse> list(@RequestParam(required=true,name="categoryId") Long categoryId) {
		return subCategoryService.list(categoryId);
	}

	@PostMapping("/api/subcategory")
	public ResponseEntity<SubCategory> save(@Valid  @RequestBody SubCategoryRequest categoryRequest) throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ResponseEntity.ok(subCategoryService.save(userDetails,categoryRequest));
	}

}
