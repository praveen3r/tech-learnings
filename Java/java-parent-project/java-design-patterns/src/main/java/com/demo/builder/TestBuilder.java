package com.demo.builder;

public class TestBuilder {

	public static void main(String[] args) {
		Bank bank = new Bank.BankBuilder("HDFC", "Whitefield").build();
		
		System.out.println(bank);

		Bank bank1 = new Bank.BankBuilder("HDFC", "Whitefield").setHeadOffice(true).build();
		
		System.out.println(bank1);
	}

}
