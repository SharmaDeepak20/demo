package com.org.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Account {

	@Id
	private String accountNo;
	private Date date;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNo, Date date) {
		super();
		this.accountNo = accountNo;
		this.date = date;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", date=" + date + "]";
	}
}
