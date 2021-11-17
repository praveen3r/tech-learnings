package com.demo.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class TestBlockingQueue {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

		Runnable producer = () -> {
			while (true) {
				Integer producedElement = ThreadLocalRandom.current().nextInt();
				try {
					queue.put(producedElement);
					System.out.println("Putting number into queue " + producedElement);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		Runnable consumer = () -> {
			while (true) {
				try {
					Integer consumedElement = queue.take();
					System.out.println("consumedElement number into queue " + consumedElement);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		executor.execute(producer);
		executor.execute(consumer);
	}

}
