package com.demo.string;

public class TestStringHashCodeCaching {

	public static void main(String[] args) {
		String str = "Test";
		str.hashCode();
		str.hashCode();
		String str1 = "Test";
		str1.hashCode();
		String str2 = new String("Test");
		str2.hashCode();
		
	}

}
