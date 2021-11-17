package com.demo.concurrency.phaser;

import java.util.concurrent.Phaser;

public class TrainPhaserLatch implements Runnable {

	Phaser phaser;
	
	TrainPhaserLatch(Phaser phaser){
		this.phaser = phaser;
		this.phaser.register();
	}
	
	public void run() {
		System.out.println("Train with phaser name " + Thread.currentThread().getName() + " has started " + " with phase " + phaser.getPhase());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number of train arrived " + phaser.getArrivedParties());
		
		phaser.arrive();
		
		System.out.println("Number of train arrived now " + phaser.getArrivedParties());
		
		System.out.println("Train with phaser name " + Thread.currentThread().getName() + " has reached");
	}
}
