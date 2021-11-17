package com.demo.yield;

public class TestYieldThread {

	public static void main(String[] args) {
		YieldTrain train = new YieldTrain();
		
		Thread thread1 = new Thread(train,"train1");
		Thread thread2 = new Thread(train,"train2");
		Thread thread3 = new Thread(train,"train3");
		Thread thread4 = new Thread(train,"train4");
		Thread thread5 = new Thread(train,"train5");
		Thread thread6 = new Thread(train,"train6");
		Thread thread7 = new Thread(train,"train7");
		Thread thread8 = new Thread(train,"train8");
		Thread thread9 = new Thread(train,"train9");
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread4.setPriority(Thread.NORM_PRIORITY);
		thread5.setPriority(Thread.NORM_PRIORITY);
		thread6.setPriority(Thread.NORM_PRIORITY);
		
		thread7.setPriority(Thread.MIN_PRIORITY);
		thread8.setPriority(Thread.MIN_PRIORITY);
		thread9.setPriority(Thread.MIN_PRIORITY);
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		
	}
	
}
