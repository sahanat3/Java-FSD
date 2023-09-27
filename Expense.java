package application;

import java.util.Date;

public class Expense {
	 private Date date;
	    private double amount;

	    public Expense(Date date, double amount) {
	        this.date = date;
	        this.amount = amount;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public double getAmount() {
	        return amount;
	    }
	}