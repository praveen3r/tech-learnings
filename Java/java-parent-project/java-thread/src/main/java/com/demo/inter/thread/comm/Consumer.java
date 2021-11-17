package com.demo.inter.thread.comm;

public class Consumer implements Runnable{

	Train train;
	
	public Consumer(Train train) {
		this.train = train;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		while(true) {
			this.train.getDistanceCovered();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
