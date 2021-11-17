package com.demo.chain.of.responsibility;

public class TestChainOfResponsibility {

	public static void main(String[] args) {
		
		Chain chain1 = new AddNumbers();
		Chain chain2 = new SubtractNumbers();
		Chain chain3 = new MultiplyNumbers();

		chain1.nextChain(chain2);
		chain2.nextChain(chain3);
		
		chain1.calculate(new Numbers(4, 2, "add"));
		chain1.calculate(new Numbers(4, 2, "mul"));
	}

}
