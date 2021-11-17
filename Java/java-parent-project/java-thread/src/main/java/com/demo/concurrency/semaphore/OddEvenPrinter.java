package com.demo.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class OddEvenPrinter {

	Semaphore evenSemaphore = new Semaphore(0);
	Semaphore oddSemaphore = new Semaphore(1);
	
	public void printEvenNumber(int num) {
		try {
			evenSemaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		oddSemaphore.release();
	}
 
	public void printOddNum(int num) {
		try {
			oddSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		evenSemaphore.release();
 
	}
}
