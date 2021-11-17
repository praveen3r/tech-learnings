package com.demo.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {

	public static void main(String[] args) {
		TestSemaphore testSemaphore = new TestSemaphore();
		testSemaphore.execute();
	}

	public void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Semaphore semaphore = new Semaphore(3);
		
		for (int i = 0; i <= 10; i++) {
			executor.execute(new Runnable() {

				public void run() {
					
					System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for permit");
					try {
						//semaphore.acquireUninterruptibly();
						semaphore.acquire();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Thread " + Thread.currentThread().getName() + " could not acquire permit");
					}
					System.out.println("Thread " + Thread.currentThread().getName() + " has acquired permit and processing");
					System.out.println( "Available Semaphore permits now after acquire: " + semaphore.availablePermits());
					
					semaphore.release();
					
					System.out.println("Thread " + Thread.currentThread().getName() + " has released");
					System.out.println( "Available Semaphore permits after releasing: " + semaphore.availablePermits());

				}
			});
		}
		
		executor.shutdown();

	}
}
