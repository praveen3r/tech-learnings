package com.demo.queue;

public class TestCustomQueue {

	static CustomQueue<Integer> customQueue = new CustomQueue<>();
	
	public static void main(String[] args) {
		insertData();
		removeData();
		removeData();
	}

	private static void insertData() {
		
		customQueue.enQueue(13);
		customQueue.enQueue(12);
		customQueue.enQueue(11);
		customQueue.enQueue(10);
		customQueue.enQueue(9);
	}

	private static void removeData() {
		Integer dataRemoved=0;;
		try {
			dataRemoved = customQueue.deQueue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dataRemoved->" +dataRemoved);
	}

}
