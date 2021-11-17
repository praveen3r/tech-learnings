package com.demo.concurrency.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class TestPhaser {

	public static void main(String[] args) {
		TestPhaser testPhaser = new TestPhaser();
		testPhaser.executeAsCyclicBarrier();
	}

	public void executeAsCountDownLatch() {
		Phaser phaser = new Phaser(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i =0; i<3 ; i++) {
			executor.submit(new TrainPhaserLatch(phaser));
		}
		
		System.out.println("Main thread is awaiting");
		
		int value = phaser.awaitAdvance(3);
		
		System.out.println("no of phases "+ value);
		
		System.out.println("tasks completed, main thread is proceeding");
		
		executor.shutdown();

	}
	
	public void executeAsCyclicBarrier() {
		Phaser phaser = new Phaser(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.submit(new TrainPhaserBarrier(phaser));
		executor.submit(new TrainPhaserBarrier(phaser));
		executor.submit(new TrainPhaserBarrier(phaser));
		
		
		executor.submit(new TrainPhaserBarrier(phaser));
		executor.submit(new TrainPhaserBarrier(phaser));
		executor.submit(new TrainPhaserBarrier(phaser));
		
		
		executor.shutdown();

	}
}
