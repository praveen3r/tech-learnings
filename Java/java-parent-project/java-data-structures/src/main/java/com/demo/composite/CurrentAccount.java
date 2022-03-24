package com.demo.composite;

public class CurrentAccount implements Account {

	private int balance;
	
	public CurrentAccount(int balance) {
		this.balance = balance;
	}


	@Override
	public int getBalance() {
		return balance;
	}


}
