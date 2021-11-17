package com.demo.concurrency.lock;

public class ProducerQueue implements Runnable{

	TrainQueue train;
	
	public ProducerQueue(TrainQueue train) {
		this.train = train;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		int distance = 0;
		while(true) {
			try {
				this.train.setDistanceCovered(++distance);
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
