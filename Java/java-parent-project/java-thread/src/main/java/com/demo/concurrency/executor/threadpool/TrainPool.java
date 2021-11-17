package com.demo.concurrency.executor.threadpool;

public class TrainPool implements Runnable {

	String name;
	
	TrainPool(String name){
		this.name = name;
	}
	
	public void run() {
		System.out.println("Train " + name  + " with " + Thread.currentThread().getName() + " has started");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Train " + name + " with " + Thread.currentThread().getName() + " has reached destination");
	}
}
