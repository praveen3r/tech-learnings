package com.demo.concurrency.lock;

public class TestInterCommThreadQueue {

	public static void main(String[] args) {
		TrainQueue train = new TrainQueue();
		ProducerQueue producer = new ProducerQueue(train);
		ConsumerQueue consumer= new ConsumerQueue(train);
	}
	
}
