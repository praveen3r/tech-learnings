package com.demo.inter.thread.comm;

public class Consumer1 implements Runnable{

	Train1 train;
	
	public Consumer1(Train1 train) {
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
