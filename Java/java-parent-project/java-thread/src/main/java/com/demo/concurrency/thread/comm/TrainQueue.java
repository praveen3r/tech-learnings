package com.demo.concurrency.thread.comm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TrainQueue {

	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);

	public void getDistanceCovered() {
		int distanceCovered = 0;
		try {
			distanceCovered = queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getDistanceCovered->"+distanceCovered);
	}

	public void setDistanceCovered(int distanceCovered) {
		System.out.println("setDistanceCovered->"+distanceCovered);
		try {
			queue.put(distanceCovered);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
