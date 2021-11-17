package com.demo.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class TrainBarrier implements Runnable {

	CyclicBarrier barrier;
	
	TrainBarrier(CyclicBarrier barrier){
		this.barrier = barrier;
	}
	
	public void run() {
		System.out.println("Train " + Thread.currentThread().getName() + " is waiting for " + barrier.getNumberWaiting());
		
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Train " + Thread.currentThread().getName() + " has started");
		
	}
}
