package com.demo.chain.of.responsibility;

public class AddNumbers implements Chain {

	Chain chain;

	@Override
	public void nextChain(Chain chain) {
		this.chain = chain;
	}

	@Override
	public void calculate(Numbers request) {
		if (request.getTypeOfOperation().equals("add")) {
			System.out.println("adding " + request.getNum1() + " and " + request.getNum2() + " with result "
					+ (request.getNum1() + request.getNum2()));
		} else {
			System.out.println("not add, passing to next chain");
			chain.calculate(request);
		}

	}

}
