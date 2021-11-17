package com.demo.concurrency.lock;

public class TestIncrementThread {

	public static void main(String[] args) {
		Increment increment = new Increment();
		IncrementThread1 thread1 = new IncrementThread1(increment);
		IncrementThread2 thread2= new IncrementThread2(increment);
	}
	
}
