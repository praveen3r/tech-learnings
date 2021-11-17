package com.demo.concurrency.phaser;

import java.util.concurrent.Phaser;

public class TrainPhaserBarrier implements Runnable {

	Phaser phaser;
	
	TrainPhaserBarrier(Phaser phaser){
		this.phaser = phaser;
	}
	
	public void run() {
		System.out.println("Train with phaser name " + Thread.currentThread().getName() + " has started " + " with phase " + phaser.getPhase() + " and is waiting for "+phaser.getRegisteredParties());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("Train with phaser name " + Thread.currentThread().getName() + " has reached");
	}
}
