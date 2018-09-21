package com.org.bean;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Transaction extends Account{

	private double amount;
	private String status;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String accountNo, Date date, double amount, String status) {
		super(accountNo, date);
		this.amount = amount;
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", status=" + status + "]";
	}	
}
