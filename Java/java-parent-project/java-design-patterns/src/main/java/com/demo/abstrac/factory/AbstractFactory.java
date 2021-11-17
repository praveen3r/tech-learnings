package com.demo.abstrac.factory;

public interface AbstractFactory {

	Bank getBank(String name);
	Loan getLoan(String name);
}
