package com.demo.concurrency.operations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class TestLongAdder {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		LongAdder longAdder = new LongAdder();
		
		for(int i=0; i<10; i++) {
			executor.submit(new Task(longAdder));
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final count " + longAdder.longValue());
		executor.shutdown();
		
	}
	
	public static class Task implements Runnable{
		
		LongAdder longAdder;
		
		public Task(LongAdder longAdder) {
			this.longAdder = longAdder;
		}
		
		public void run() {
			System.out.println(Thread.currentThread().getName() + " initial value " + longAdder.longValue());
			longAdder.increment();
			System.out.println(Thread.currentThread().getName() + " value " + longAdder.longValue());
		}
		
	}

}
