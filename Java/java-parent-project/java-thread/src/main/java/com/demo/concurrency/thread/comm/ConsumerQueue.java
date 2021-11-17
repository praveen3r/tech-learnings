package com.demo.concurrency.thread.comm;

public class ConsumerQueue implements Runnable{

	TrainQueue train;
	
	public ConsumerQueue(TrainQueue train) {
		this.train = train;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		while(true) {
			this.train.getDistanceCovered();
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}
