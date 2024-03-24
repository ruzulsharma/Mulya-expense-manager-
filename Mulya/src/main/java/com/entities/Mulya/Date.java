package com.entities.Mulya;
import javax.persistence.Embeddable;

@Embeddable
public class Date {
    private int day;
    private int month;
    private int year;

    // Constructors, getters, and setters
    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    public String getFormattedDate() {
        return String.format("%02d-%02d-%04d", day, month, year); // Format: dd-mm-yyyy
    }
}
