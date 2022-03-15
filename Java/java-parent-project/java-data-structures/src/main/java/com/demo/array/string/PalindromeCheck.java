package com.demo.array.string;

public class PalindromeCheck {

	public static void main(String[] args) {
		checkIfPalindrome("madame");

	}
	
	public static void checkIfPalindrome(String inputStr) {
		char[] charArr = inputStr.toCharArray();
		int start = 0;
		int end = inputStr.length() -1;
		while(start < end) {
			if(charArr[start] != charArr[end]) {
				System.out.println(false);
				return;
			}
			start++;
			end--;
		}
		System.out.println("It is a palindrome");
	}

}
