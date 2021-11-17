package com.demo.concurrency.thread.comm;

public class TestInterCommThreadQueue {

	public static void main(String[] args) {
		TrainQueue train = new TrainQueue();
		ProducerQueue producer = new ProducerQueue(train);
		ConsumerQueue consumer= new ConsumerQueue(train);
	}
	
}
