package com.demo.concurrency.lock;

public class ConsumerQueue implements Runnable{

	TrainQueue train;
	
	public ConsumerQueue(TrainQueue train) {
		this.train = train;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		while(true) {
			try {
				this.train.getDistanceCovered();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}
