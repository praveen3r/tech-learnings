package com.demo.concurrency.lock;

public class IncrementThread1 implements Runnable{

	Increment increment;
		
		public IncrementThread1(Increment increment) {
			this.increment = increment;
			Thread thread = new Thread(this);
			thread.start();
		}

		public void run() {
				try {
					this.increment.incrementByFirstThread();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
}
