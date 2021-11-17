package com.demo.string;

public class TestStringIntern {

	public static void main(String[] args) {
		
		String str1 = new String("Test");
		String str2 = "Test";
		String str3 = "Test";
		
		System.out.println("str1 == str2? "+ (str1==str2));
		System.out.println("str2 == str3? "+ (str2==str3));
		
		String str4 = str1.intern();
		System.out.println("str4 == str2? "+ (str4==str2));
	}

}
