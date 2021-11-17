package com.demo.exception;

import com.demo.exception.Bank;

public class TestException {

	public static void main(String[] args) throws Exception{
		Bank bank = new Bank();
		//bank.exceptionWithTryCatch();
		bank.exceptionWithThrows();
	}

}
