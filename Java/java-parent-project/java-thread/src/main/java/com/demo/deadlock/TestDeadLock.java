package com.demo.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadLock {

	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Process1());
		Thread thread2 = new Thread(new Process2());
		thread1.start();
		thread2.start();
		
		DetectDeadlock.detectDeadLocks();

	}

	static class Process1 implements Runnable {
		public void run() {
			
			lock1.lock();
			lock2.lock();
			
			System.out.println("Process1");
			
			lock1.unlock();
			lock2.unlock();
		}
	}

	static class Process2 implements Runnable {
		public void run() {
			
			lock2.lock();
			lock1.lock();
			
			System.out.println("Process2");
			
			lock2.unlock();
			lock1.unlock();
		}
	}

}
