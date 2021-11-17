package com.demo.concurrency.operations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class TestLongAccumulator {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		LongAccumulator longAccumulator = new LongAccumulator((x,y) -> x + y, 0);
		
		for(int i=0; i<10; i++) {
			executor.submit(new Task(longAccumulator));
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final count " + longAccumulator.get());
		executor.shutdown();
		
	}
	
	public static class Task implements Runnable{
		
		LongAccumulator longAccumulator;
		
		public Task(LongAccumulator longAccumulator) {
			this.longAccumulator = longAccumulator;
		}
		
		public void run() {
			longAccumulator.accumulate(1);
		}
		
	}

}
