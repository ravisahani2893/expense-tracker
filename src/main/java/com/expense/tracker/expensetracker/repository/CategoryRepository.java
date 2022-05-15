package com.expense.tracker.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("select CASE WHEN COUNT(c) > 0 THEN true ELSE false END from Category c where c.id =:id and c.user.id = :userId")
	boolean existsByIdAndUserId(@Param("id") Long id,@Param("userId") Long userId);
}
