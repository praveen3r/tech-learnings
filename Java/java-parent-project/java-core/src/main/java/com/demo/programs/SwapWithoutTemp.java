package com.demo.programs;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swapString();
		swapNumbers();
	}
	
	static void swapString() {
		String a = "Love";  
        String b = "You";  
        System.out.println("Before swap: " + a + " " + b);  
        a = a + b;  
        b = a.substring(0, a.length() - b.length());  
        a = a.substring(b.length());  
        System.out.println("After : " + a + " " + b);  
	}
	
	static void swapNumbers() {
		int a = 10;  
        int b = 7;  
        System.out.println("Before swap: " + a + " " + b);  
        a = a + b;  
        b = a-b;  
        a = a-b;  
        System.out.println("After : " + a + " " + b);  
	}

}
