package com.expense.tracker.expensetracker.service;

import java.util.List;

import javax.transaction.Transactional;

import com.expense.tracker.expensetracker.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expense.tracker.expensetracker.entity.auth.User;
import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.repository.CategoryRepository;
import com.expense.tracker.expensetracker.repository.UserRepository;
import com.expense.tracker.expensetracker.request.dto.CategoryRequest;
import com.expense.tracker.expensetracker.response.dto.CategoryResponse;

@Service
public class CategoryService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional
	public Category save(UserDetails userDetail,CategoryRequest categoryRequest) {
		User user= userRepository.findByUsername(userDetail.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetail.getUsername()));
		
		Category category=new Category();
		category.setName(categoryRequest.getName());
		category.setActive(true);
		category.setUser(user);
		return categoryRepository.save(category);
	}
	
	@Transactional
	public List<CategoryResponse> list(UserDetails userDetail){
		User user= userRepository.findByUsername(userDetail.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetail.getUsername()));
		return categoryRepository.listCategory(user.getId());
	}
	

}
