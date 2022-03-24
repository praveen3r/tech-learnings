package com.demo.factory;

public class TestFactoryPattern {

	/*
	 * In factory pattern objects will be created in a single place
	 */
	public static void main(String[] args) {
		Calculator calculator = CalculateFactory.getCalculate("add");
		double result = calculator.calculate(1.0,2.0);
		System.out.println(result);
	}

}
