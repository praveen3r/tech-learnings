package com.demo.thread.others;

public class TestThreadStop {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while(!Thread.currentThread().interrupted()) {
				System.out.println("task running");
			}
		});
		
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.interrupt();
	}
}
