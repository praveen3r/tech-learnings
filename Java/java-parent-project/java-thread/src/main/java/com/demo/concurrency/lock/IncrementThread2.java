package com.demo.concurrency.lock;

public class IncrementThread2 implements Runnable{

	Increment increment;
		
		public IncrementThread2(Increment increment) {
			this.increment = increment;
			Thread thread = new Thread(this);
			thread.start();
		}

		public void run() {
				try {
					this.increment.incrementBySecondThread();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
}
