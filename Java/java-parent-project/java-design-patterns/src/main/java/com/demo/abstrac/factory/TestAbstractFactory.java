package com.demo.abstrac.factory;

public class TestAbstractFactory {

	public static void main(String[] args) {
		
		AbstractFactory factory = FactoryCreator.getFactory("Bank");
		Bank bank = factory.getBank("HDFC");
		System.out.println(bank.getBankName());
		
		AbstractFactory factory1 = FactoryCreator.getFactory("Loan");
		Loan loan = factory1.getLoan("Home");
		System.out.println(loan.getRate());
	}
}
