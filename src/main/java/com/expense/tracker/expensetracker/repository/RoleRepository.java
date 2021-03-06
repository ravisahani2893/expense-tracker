package com.expense.tracker.expensetracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.tracker.expensetracker.entity.auth.ERole;
import com.expense.tracker.expensetracker.entity.auth.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByName(ERole name);

}
