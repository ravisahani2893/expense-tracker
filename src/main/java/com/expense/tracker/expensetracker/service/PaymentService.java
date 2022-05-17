package com.expense.tracker.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expense.tracker.expensetracker.entity.expensetracker.PaymentType;
import com.expense.tracker.expensetracker.exception.handler.EntityException;
import com.expense.tracker.expensetracker.repository.PaymentTypeRepository;
import com.expense.tracker.expensetracker.request.dto.PaymentTypeRequest;
import com.expense.tracker.expensetracker.request.dto.UpdatePaymentTypeRequest;

@Service
public class PaymentService {

	
	@Autowired
	private PaymentTypeRepository repository;
	
	public List<PaymentType> list(){
		return repository.findAll();
	}
	
	public PaymentType save(PaymentTypeRequest request) {
		PaymentType paymentType=new PaymentType();
		paymentType.setType(request.getType());
		paymentType.setActive(true);
		return repository.save(paymentType);
		 
	}
	
	public PaymentType update(Long paymentId,UpdatePaymentTypeRequest request) throws Exception {
		PaymentType type=repository.findById(paymentId).orElseThrow(() -> new EntityException("Payment Type not found"));
		type.setType(request.getType());
		type.setActive(request.isActive());
		return repository.save(type);
		 
	}
	

}
