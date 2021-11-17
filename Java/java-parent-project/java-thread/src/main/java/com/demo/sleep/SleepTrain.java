package com.demo.sleep;

public class SleepTrain implements Runnable {

	public void run() {
		for(int i=1; i<= 100; i++) {
			System.out.println("Train " + Thread.currentThread().getName() + " has covered a distance of " + i + " meters");
			
			if( i== 15 && Thread.currentThread().getName().equals("Thoothukudi Express"))
				try {
					Thread.sleep(1000 * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		System.out.println("Train " + Thread.currentThread().getName() + " has reached destination");
	}
}
