package com.demo.stack;

public class ReverseString {

	public static void main(String[] args) {
		reverse("Shree");
	}
	
	private static void reverse(String input) {
		char[] charArr = input.toCharArray();
		CustomStack<Character> customStack = new CustomStack<>();
		for(int i=0; i<charArr.length;i++ ) {
			customStack.push(charArr[i]);
		}
		
		for(int i=0; i<charArr.length;i++ ) {
			charArr[i] = customStack.pop();
		}
		String reverse = new String(charArr);
		System.out.println(reverse);
	}

}
