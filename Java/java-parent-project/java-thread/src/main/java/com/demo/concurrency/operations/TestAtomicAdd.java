package com.demo.concurrency.operations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class TestAtomicAdd {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		AtomicLong atomicLong = new AtomicLong(0);
		
		for(int i=0; i<10; i++) {
			executor.submit(new Task(atomicLong));
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final count " + atomicLong.get());
		executor.shutdown();
		
	}
	
	public static class Task implements Runnable{
		
		AtomicLong atomicLong;
		
		public Task(AtomicLong atomicLong) {
			this.atomicLong = atomicLong;
		}
		
		public void run() {
			System.out.println(" value of atomicLong in " + Thread.currentThread().getName() + " is "+ atomicLong.get());
			atomicLong.incrementAndGet();
		}
		
	}

}
