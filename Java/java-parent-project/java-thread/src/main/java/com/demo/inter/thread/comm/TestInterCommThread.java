package com.demo.inter.thread.comm;

public class TestInterCommThread {

	public static void main(String[] args) {
		
		/*Train train = new Train();

		Producer producer = new Producer(train);
		Consumer consumer = new Consumer(train);*/
		 
		 
		Train1 train = new Train1();
		Producer1 producer = new Producer1(train);
		//Producer1 producer1 = new Producer1(train);
		Consumer1 consumer= new Consumer1(train);
	}
	
}
