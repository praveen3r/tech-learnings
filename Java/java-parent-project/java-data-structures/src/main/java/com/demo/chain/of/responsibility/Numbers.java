package com.demo.chain.of.responsibility;

public class Numbers {

	int num1;
	int num2;
	String typeOfOperation;
	
	public Numbers(int num1, int num2, String typeOfOperation) {
		this.num1 = num1;
		this.num2 = num2;
		this.typeOfOperation = typeOfOperation;
	}

	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public String getTypeOfOperation() {
		return typeOfOperation;
	}
	
	
	
	
}
