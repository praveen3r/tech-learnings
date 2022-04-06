package com.demo.array.integer;

public class ReverseInteger {

	public static void main(String[] args) {
		reverseInteger(1234);
	}
	
	private static void reverseInteger(int number) {
		boolean isNegative = number < 0;
		if(isNegative) {
			number = number * -1;
		}
		
		int lastDigit = 0;
		int reverse = 0;
		while(number > 0) {
			lastDigit = number % 10;
			reverse = reverse * 10 + lastDigit;
			number = number/10;
		}
		
		reverse = (isNegative)? reverse * -1: reverse;
		System.out.println(reverse);
	}

}
