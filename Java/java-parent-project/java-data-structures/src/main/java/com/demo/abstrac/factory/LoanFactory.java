package com.demo.abstrac.factory;

public class LoanFactory implements AbstractFactory {

	@Override
	public Loan getLoan(String name) {
		Loan loan = null;
		if(name.equals("Home")) {
			loan = new HomeLoan();
		}else  {
			loan = new EducationLoan();
		}
		return loan;
	}

	@Override
	public Bank getBank(String name) {
		return null;
	}

}
