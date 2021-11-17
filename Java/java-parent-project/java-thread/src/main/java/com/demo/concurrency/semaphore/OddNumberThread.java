package com.demo.concurrency.semaphore;

public class OddNumberThread implements Runnable{

	OddEvenPrinter printer;
	int maxNumberTobePrint;
 
	OddNumberThread(OddEvenPrinter printer, int index) {
		this.printer = printer;
		this.maxNumberTobePrint = index;
	}
 
	@Override
	public void run() {
		for (int i = 1; i <= maxNumberTobePrint; i = i + 2) {
			printer.printOddNum(i);
		}
 
	}
}
