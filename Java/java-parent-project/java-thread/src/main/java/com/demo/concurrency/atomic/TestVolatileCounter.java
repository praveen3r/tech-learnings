package com.demo.concurrency.atomic;

public class TestVolatileCounter implements Runnable{

	volatile int counter = 0;
	
	public TestVolatileCounter() {
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
			System.out.println(Thread.currentThread().getName() + " counter value is "+counter);
		}
	}
}
