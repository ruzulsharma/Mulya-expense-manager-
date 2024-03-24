package com.entities.Mulya;

import java.util.*;

import javax.persistence.*;

import org.hibernate.Session;

@Entity
@Table(name = "Expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseId;
	
	@ManyToOne
	@Column(name = "user_id") // Assuming the column name in the database is "user_id"
	private UserDetails uId; // Change the type to String

	private double ExpenseAmount;
	private String description;

	@Embedded
	private Date date;

	// Getter and Setter
	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public UserDetails getuId() {
		return uId;
	}

	public void setuId(UserDetails userId) {
		this.uId = userId;
	}

	public double getExpenseAmount() {
		return ExpenseAmount;
	}

	public void setExpenseAmount(double ExpenseAmount) {
		this.ExpenseAmount = ExpenseAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// Constructor
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(int expenseId, UserDetails uId, double ExpenseAmount, String description, Date date) {
		super();
		this.expenseId = expenseId;
		this.uId = uId;
		this.ExpenseAmount = ExpenseAmount;
		this.description = description;
		this.date = date;
	}

}
