package com.demo.abstrac.factory;

public class BankFactory implements AbstractFactory{

	public Bank getBank(String name) {
		Bank bank = null;
		if(name.equals("HDFC")) {
			bank = new HDFCBank();
		}else  {
			bank = new ICICIBank();
		}
		return bank;
	}

	@Override
	public Loan getLoan(String name) {
		return null;
	}
	
}
