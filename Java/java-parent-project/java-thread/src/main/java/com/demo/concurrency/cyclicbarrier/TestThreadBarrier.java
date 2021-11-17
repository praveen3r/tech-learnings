package com.demo.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadBarrier {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i =0; i<=3 ; i++) {
			executor.submit(new TrainBarrier(barrier));
		}
		
		executor.shutdown();
	}
	
}
