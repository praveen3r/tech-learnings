package com.demo.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

	public static void main(String[] args) {
		int threadCount = 3;
		ExecutorService es = Executors.newFixedThreadPool(threadCount);
		final ReentrantLock reentrantLock = new ReentrantLock();
		for (int i=0; i< threadCount; i++) {
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					try {
						//boolean flag = reentrantLock.tryLock();
						//boolean flag = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS);
						//reentrantLock.lockInterruptibly();
						reentrantLock.lock();
						   //if it is not able to acquire lock because of other threads interrupts,
						   //it will throw InterruptedException and control will go to catch block.
						//if (flag) {
						if (true) {
						    try {
								System.out.println(Thread.currentThread().getName() +": Lock acquired.");
								System.out.println("Performing task...");
						    } finally {
								System.out.println(Thread.currentThread().getName() +": Lock released.");
								reentrantLock.unlock();
						    }
						}else{
							System.out.println(Thread.currentThread().getName() + " is waiting for lock");
						}
					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
			});
		}
		
		es.shutdownNow();
	}
}
