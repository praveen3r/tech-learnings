package com.demo.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class DataConsuming implements Runnable {
	
	Exchanger exchanger = null;
	User user = null;

	DataConsuming(Exchanger exchanger, User user) {
		this.exchanger = exchanger;
		this.user = user;
	}

	@Override
	public void run() {
		User previous = this.user;

		try {
			this.user = (User) this.exchanger.exchange(this.user);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.user);

	}


}
