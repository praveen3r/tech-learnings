package com.demo.chain.of.responsibility;

public interface Chain {
	
	void nextChain(Chain chain);
	
	void calculate(Numbers request);

}
