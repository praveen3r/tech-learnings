package com.demo.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLatch {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(2);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i =0; i<=3 ; i++) {
			executor.submit(new TrainLatch(latch));
		}
		
		try {
			System.out.println("Main thread is awaiting");
			
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //timeout function so if executor doesn't finish in 1 day it terminates.
		
		System.out.println("tasks completed, main thread is proceeding");
		
		executor.shutdown();
	}
	
}
