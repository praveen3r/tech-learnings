package com.demo.composite;

public class DepositAccount implements Account {

	private int balance;
	
	public DepositAccount(int balance) {
		this.balance = balance;
	}


	@Override
	public int getBalance() {
		return balance;
	}

}
