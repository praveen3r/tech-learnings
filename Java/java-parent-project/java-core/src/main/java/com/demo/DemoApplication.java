package com.demo;

import com.demo.exception.Bank;

public class DemoApplication {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.exceptionWithTryCatch();
	}

}
