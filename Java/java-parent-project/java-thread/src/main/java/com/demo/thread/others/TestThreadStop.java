package com.demo.thread.others;

public class TestThreadStop {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while(!Thread.currentThread().interrupted()) {
				
				System.out.println("task running1");
				
				System.out.println("task running2");
				
				System.out.println("task running3");
				
				System.out.println("task running4");
			}
			System.out.println("thread interrupted");
		});
		
		t1.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.interrupt();
	}
}
