package com.demo.concurrency.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;

public class TestSynchronousQueue {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

		Runnable producer = () -> {
			while(true){
				Integer producedElement = ThreadLocalRandom.current().nextInt();
				try {
					queue.put(producedElement);
					System.out.println("Putting number into queue "+ producedElement);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};
		
		Runnable consumer = () -> {
			while(true){
				    try {
				        Integer consumedElement = queue.take();
				        System.out.println("consumedElement number into queue "+ consumedElement);
				    } catch (InterruptedException ex) {
				        ex.printStackTrace();
				    }
				}
			};
		
		
		executor.execute(producer);
		executor.execute(consumer);
		
		

	}

}
