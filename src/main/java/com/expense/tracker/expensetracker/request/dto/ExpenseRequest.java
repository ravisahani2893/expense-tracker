package com.expense.tracker.expensetracker.request.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ExpenseRequest {

	@NotNull(message="Amount should not be null.")
	@Min(value = 0L, message = "Amount value must be positive.")
	private BigDecimal amount;
	
	private String expenseDescription;
	@NotNull(message="Payment Type Id should not be null.")
	private Long paymentId;
	@NotNull(message="Category Id should not be null.")
	private Long categoryId;

	@NotNull(message="Sub Category Id should not be null.")
	private Long subCategoryId;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
}
