package com.demo.programs;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reversString("Ragupathy");
		reversStringWithApi("Ragupathy");
		reverseNumber(1677);
	}
	
	static void reversStringWithApi(String input) {
		StringBuilder sb=new StringBuilder(input);
		System.out.println(sb.reverse().toString());
	}
	
	static void reversString(String input) {
		StringBuilder sb=new StringBuilder();
		for(int i=input.length()-1;i>=0;i--) {
			sb.append(input.charAt(i));
		}
		System.out.println(sb.toString());
	}
	
	static void reverseNumber(int num) {
		int reversed=0;
		while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println("Reversed Number: " + reversed);
	}

}
