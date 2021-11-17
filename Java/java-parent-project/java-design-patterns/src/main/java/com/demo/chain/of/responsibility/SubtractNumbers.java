package com.demo.chain.of.responsibility;

public class SubtractNumbers implements Chain {

	Chain chain;

	@Override
	public void nextChain(Chain chain) {
		this.chain = chain;
	}

	@Override
	public void calculate(Numbers request) {
		if (request.getTypeOfOperation().equals("sub")) {
			System.out.println("subtracting " + request.getNum1() + " and " + request.getNum2() + " with result "
					+ (request.getNum1() - request.getNum2()));
		} else {
			System.out.println("not sub, passing to next chain");
			chain.calculate(request);
		}

	}

}
