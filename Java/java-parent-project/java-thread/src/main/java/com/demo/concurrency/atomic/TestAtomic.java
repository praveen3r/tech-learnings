package com.demo.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic implements Runnable{
	
	AtomicInteger counter = new AtomicInteger(1);
	
	public TestAtomic() {
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " counter value is "+counter.incrementAndGet());
		}
	}
}
