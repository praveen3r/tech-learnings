package com.demo.join;

public class JoinTrain implements Runnable {

	public void run() {
		for(int i=1; i<= 100; i++) {
			System.out.println("Train " + Thread.currentThread().getName() + " has covered a distance of " + i + " meters");
		}
		System.out.println("Train " + Thread.currentThread().getName() + " has reached destination");
	}
}
