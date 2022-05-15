package com.expense.tracker.expensetracker.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.expense.tracker.expensetracker.entity.auth.User;

@Repository
public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<User,Long>  {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}
