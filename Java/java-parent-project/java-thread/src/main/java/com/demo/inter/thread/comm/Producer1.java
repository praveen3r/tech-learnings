package com.demo.inter.thread.comm;

public class Producer1 implements Runnable{

	Train1 train;
	
	public Producer1(Train1 train) {
		this.train = train;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		int distance = 0;
		while(true) {
			this.train.setDistanceCovered(++distance);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
