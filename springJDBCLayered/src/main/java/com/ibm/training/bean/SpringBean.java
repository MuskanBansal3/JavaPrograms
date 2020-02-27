package com.ibm.training.bean;

import java.sql.Date;

public class SpringBean {
	int accountNumber;
	String holderName;
	double holderContactNumber;
	int accountBalance;
	int transactionNumber;
	int transactionAmount;
	Date transactionTime;
	String exception;
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getHolderContactNumber() {
		return holderContactNumber;
	}
	public void setHolderContactNumber(double holderContactNumber) {
		this.holderContactNumber = holderContactNumber;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	@Override
	public String toString() {
		return "the transaction number is : " + this.transactionNumber + " ,"
				+ "  the account number is : " + this.accountNumber + " ,"
				+ "  the transaction ammount is : " + this.transactionAmount + " ,"
				+ "  the transaction date is : " + this.transactionTime;
	}
	
	public String printData() {
		return    "  the account number is : " + this.accountNumber + " ,"
				+ "  the name is : " + this.holderName + " ,"
				+ "  the contact number is : " + this.holderContactNumber + " ,"
				+ "  the account balance is : " +this.accountBalance;
	}
	
}
