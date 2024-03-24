package com.entities.Mulya;

import javax.persistence.*;

@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserDetails user;

    private double amount;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    // Constructors
    public Income() {}

    public Income(Long incomeID, UserDetails user, double amount, String description, Date date) {
        this.incomeID = incomeID;
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters and setters
    public Long getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(Long incomeID) {
        this.incomeID = incomeID;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
