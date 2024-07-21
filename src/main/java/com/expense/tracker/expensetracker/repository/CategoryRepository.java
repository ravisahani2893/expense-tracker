package com.expense.tracker.expensetracker.repository;

import com.expense.tracker.expensetracker.response.dto.CategoryResponse;
import com.expense.tracker.expensetracker.response.dto.ExpenseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("select CASE WHEN COUNT(c) > 0 THEN true ELSE false END from Category c where c.id =:id and c.user.id = :userId")
	boolean existsByIdAndUserId(@Param("id") Long id,@Param("userId") Long userId);

	@Query("select new com.expense.tracker.expensetracker.response.dto.CategoryResponse(cat.id,cat.name,cat.user.id,cat.createdAt,cat.updatedAt) from Category cat  where cat.user.id = :userId")
	List<CategoryResponse> listCategory(@Param("userId") Long userId);



}
