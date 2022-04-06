package com.demo.queue;

import java.util.Arrays;

public class GenerateBinaryNumbers {

	public static void main(String[] args) {
		try {
			generateBinaryNumbers(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void generateBinaryNumbers(int size) throws Exception{
		CustomQueue<String> customQueue = new CustomQueue<>();
		String[] result = new String[size];
		customQueue.enQueue("1");
		for(int i=0; i<size; i++) {
			String value = customQueue.deQueue();
			String n1 = value + "0";
			String n2 = value + "1";
			customQueue.enQueue(n1);
			customQueue.enQueue(n2);
			result[i] = value;
		}
		System.out.println(Arrays.toString(result));
	}
}
