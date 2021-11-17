package com.demo.factory;

public class CalculateFactory {

	public static Calculator getCalculate(String type) {
		Calculator calculate = null;
		if(type.equals("add")){
			calculate = new Add();
		}else if(type.equals("subtact")){
			calculate = new Subtract();
		}else {
			calculate = new Divide();
		}
		return calculate;
	}
}
