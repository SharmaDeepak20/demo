package com.org.bean;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class ChequeBookRequest extends Account{

	private String status;
	
	public ChequeBookRequest() {
		// TODO Auto-generated constructor stub
	}

	public ChequeBookRequest(String accountNo, Date date, String status) {
		super(accountNo, date);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ChequeBookRequest [ status=" + status + "]";
	}
}
