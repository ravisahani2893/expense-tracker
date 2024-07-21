package com.expense.tracker.expensetracker.repository;

import com.expense.tracker.expensetracker.entity.expensetracker.Category;
import com.expense.tracker.expensetracker.entity.expensetracker.SubCategory;
import com.expense.tracker.expensetracker.response.dto.CategoryResponse;
import com.expense.tracker.expensetracker.response.dto.SubCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
	
	@Query("select CASE WHEN COUNT(c) > 0 THEN true ELSE false END from SubCategory c where c.id =:id and c.category.id = :categoryId")
	boolean existsByIdAndUserId(@Param("id") Long id,@Param("categoryId") Long categoryId);

	@Query("select new com.expense.tracker.expensetracker.response.dto.SubCategoryResponse(subCat.id,subCat.name,subCat.createdAt,subCat.updatedAt) from SubCategory subCat  where subCat.category.id = :categoryId")
	List<SubCategoryResponse> listSubCategory(@Param("categoryId") Long categoryId);
}
