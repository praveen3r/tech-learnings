package com.demo.stack;

public class TestCustomStack {

	static CustomStack<Integer> customStack = new CustomStack<>();
	
	public static void main(String[] args) {
		insertData();
		viewData();
		removeData();
		removeData();
	}

	private static void insertData() {
		
		customStack.push(13);
		customStack.push(12);
		customStack.push(11);
		customStack.push(10);
		customStack.push(9);
	}

	private static void viewData() {
		System.out.println("Current data at the top->" +customStack.peek());
	}
	
	private static void removeData() {
		Integer dataRemoved = customStack.pop();
		System.out.println("dataRemoved->" +dataRemoved);
		System.out.println("Current data at the top->" +customStack.peek());
	}

}
