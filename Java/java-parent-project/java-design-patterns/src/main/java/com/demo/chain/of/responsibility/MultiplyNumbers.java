package com.demo.chain.of.responsibility;

public class MultiplyNumbers implements Chain {

	Chain chain;

	@Override
	public void nextChain(Chain chain) {
		this.chain = chain;
	}

	@Override
	public void calculate(Numbers request) {
		if (request.getTypeOfOperation().equals("mul")) {
			System.out.println("multiplying " + request.getNum1() + " and " + request.getNum2() + " with result "
					+ (request.getNum1() * request.getNum2()));
		} else {
			System.out.println(" not add, sub, mul ");
		}

	}

}
