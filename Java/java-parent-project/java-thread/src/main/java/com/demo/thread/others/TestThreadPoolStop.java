package com.demo.thread.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPoolStop {

	public static void main(String[] args) {
	ExecutorService executor = Executors.newFixedThreadPool(2);
			
			executor.execute(new Runnable() {
				public void run() {
					while(!Thread.currentThread().interrupted()) {
						System.out.println("task running");
					}
				}
			});
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			executor.shutdownNow();
	}
}
