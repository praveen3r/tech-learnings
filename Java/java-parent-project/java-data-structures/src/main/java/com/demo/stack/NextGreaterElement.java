package com.demo.stack;

import java.util.Arrays;

public class NextGreaterElement {

	public static void main(String[] args) {

		int[] input = {4, 7, 3, 4, 8, 1};
		arrayWithNextGreaterValue(input);
	}
	
	private static void arrayWithNextGreaterValue(int[] input) {
		CustomStack<Integer> customStack = new CustomStack<>();
		int[] result = new int[input.length];
		for(int i=input.length-1; i>=0 ;i--) {
			if(!customStack.isEmpty()) {
				while(!customStack.isEmpty() && customStack.peek()<=input[i]) {
					customStack.pop();
				}
			}
			
			if(!customStack.isEmpty()) {
				result[i] = customStack.peek();
			}else {
				result[i] = -1;
			}
			customStack.push(input[i]);
		}
		System.out.println(Arrays.toString(result));
	}

}
