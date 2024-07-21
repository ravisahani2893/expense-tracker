package com.expense.tracker.expensetracker.entity.expensetracker;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name="sub_category_id")
	private SubCategory subCategoryId;
	
	@ManyToOne
	@JoinColumn(name = "payment_type_id")
	private PaymentType payment;
	
	@Column(name="expense_amount")
	private BigDecimal expenseAmount;
	@Column(name="expense_desc")
	private String expenseDescription;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "updated_at")
	private Date updatedAt;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PaymentType getPayment() {
		return payment;
	}

	public void setPayment(PaymentType payment) {
		this.payment = payment;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public SubCategory getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategory subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	@PrePersist
	protected void prePersist() {
		if (this.createdAt == null)
			createdAt = new Date();
		if (this.updatedAt == null)
			updatedAt = new Date();
	}

	@PreUpdate
	protected void preUpdate() {
		this.updatedAt = new Date();
	}

	@PreRemove
	protected void preRemove() {
		this.updatedAt = new Date();
	}

}
