package com.entities.Mulya;

import java.util.*;

import javax.persistence.*;
@Entity
@Table(name = "Expense")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;
    
    @ManyToOne
    private UserDetails uId;
    
    private double amount;
    private String description;
    private String date;
    
    //Getter and Setter
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public UserDetails getuId() {
		return uId;
	}
	public void setuId(UserDetails userid) {
		this.uId = userid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	//Constructor
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(int expenseId, UserDetails uId, double amount, String description, String date) {
		super();
		this.expenseId = expenseId;
		this.uId = uId;
		this.amount = amount;
		this.description = description;
		this.date = date;
	}
}
