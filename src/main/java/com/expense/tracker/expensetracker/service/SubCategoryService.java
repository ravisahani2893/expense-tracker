package com.expense.tracker.expensetracker.service;

import com.expense.tracker.expensetracker.entity.auth.User;
import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.entity.expensetracker.SubCategory;
import com.expense.tracker.expensetracker.exception.handler.EntityException;
import com.expense.tracker.expensetracker.repository.CategoryRepository;
import com.expense.tracker.expensetracker.repository.SubCategoryRepository;
import com.expense.tracker.expensetracker.repository.UserRepository;
import com.expense.tracker.expensetracker.request.dto.SubCategoryRequest;
import com.expense.tracker.expensetracker.response.dto.SubCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubCategoryService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@Transactional
	public SubCategory save(UserDetails userDetail, SubCategoryRequest subCategoryRequest) throws Exception {
		User user= userRepository.findByUsername(userDetail.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetail.getUsername()));

		boolean categoryExits= categoryRepository.existsByIdAndUserId(subCategoryRequest.getCategoryId(),user.getId());
		if (!categoryExits) {
			throw new EntityException("Category not found for parameters category_id:" + subCategoryRequest.getCategoryId());
		}
		Category category=categoryRepository.findById(subCategoryRequest.getCategoryId()).orElseThrow(() -> new Exception("Category not found"));;
		SubCategory subCategory=new SubCategory();
		subCategory.setName(subCategoryRequest.getName());
		subCategory.setActive(true);
		subCategory.setCategory(category);
		return subCategoryRepository.save(subCategory);
	}

	@Transactional
	public List<SubCategoryResponse> list(Long categoryId, UserDetails userDetail){
		User user= userRepository.findByUsername(userDetail.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetail.getUsername()));

		return subCategoryRepository.listSubCategory(categoryId, user.getId());
	}

}
