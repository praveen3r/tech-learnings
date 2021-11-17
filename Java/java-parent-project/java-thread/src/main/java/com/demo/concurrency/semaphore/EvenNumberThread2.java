package com.demo.concurrency.semaphore;

public class EvenNumberThread2 implements Runnable{

	OddEvenPrinter printer;
	int maxNumberTobePrint;
 
	EvenNumberThread2(OddEvenPrinter printer, int index) {
		this.printer = printer;
		this.maxNumberTobePrint = index;
	}
 
	@Override
	public void run() {
		for (int i = 2; i <= maxNumberTobePrint; i = i + 2) {
			printer.printEvenNumber(i);
		}
 
	}
}
