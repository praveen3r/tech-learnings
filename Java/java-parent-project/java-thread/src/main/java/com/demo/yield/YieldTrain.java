package com.demo.yield;

public class YieldTrain implements Runnable {

	public void run() {
		
		System.out.println(" Train "+ Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority() + " is running ");
		
		Thread.yield();
		
		System.out.println(" Train "+ Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority() + " finished running ");
		
		
	}
}
