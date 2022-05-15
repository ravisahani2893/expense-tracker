package com.expense.tracker.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.expensetracker.entity.expensetracker.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long>{

}
