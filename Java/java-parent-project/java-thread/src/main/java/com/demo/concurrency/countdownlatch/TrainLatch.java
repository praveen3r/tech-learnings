package com.demo.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TrainLatch implements Runnable {

	CountDownLatch latch;
	
	TrainLatch(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Train with latch count" + latch.getCount()  + " and name " + Thread.currentThread().getName() + " has started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Train with latch count" + latch.getCount() + " and name " + Thread.currentThread().getName() + " has reached destination");
		
		latch.countDown();
	}
}
