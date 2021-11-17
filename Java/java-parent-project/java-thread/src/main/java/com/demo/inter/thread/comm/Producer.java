package com.demo.inter.thread.comm;

public class Producer implements Runnable{

	Train train;
	
	public Producer(Train train) {
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
