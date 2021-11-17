package com.demo.composite;

public class TestCompositePattern {

	public static void main(String[] args) {
		CompositeAccount acct = new CompositeAccount();
		acct.addAccount(new DepositAccount(1000));
		acct.addAccount(new CurrentAccount(2000));
		
		System.out.println(acct.getBalance());
	}

}
