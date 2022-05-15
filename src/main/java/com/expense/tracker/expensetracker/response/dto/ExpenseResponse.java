package com.expense.tracker.expensetracker.response.dto;

import java.math.BigDecimal;

public class ExpenseResponse {
	
	private Long id;
	

	private BigDecimal expenseAmount;
	private String expenseDescription;
	private String categoryName;
	private String paymentType;
	
	
	
	public ExpenseResponse(Long id, BigDecimal expenseAmount, String expenseDescription, String categoryName,
			String paymentType) {
		super();
		this.id = id;
		this.expenseAmount = expenseAmount;
		this.expenseDescription = expenseDescription;
		this.categoryName = categoryName;
		this.paymentType = paymentType;
	}
	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	

}
