package com.demo.join;

public class TestJoinThread {

	public static void main(String[] args) {
		JoinTrain train = new JoinTrain();
		
		Thread thread1 = new Thread(train,"train1");
		Thread thread2 = new Thread(train,"train2");
		
		thread1.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		
		
	}
	
}
