package com.demo.array.string;

/*
 * A new string formed from the original string by deleting some or no characters
 * without changing the order or remaining characters
 */
public class SubsequentString {

	public static void main(String[] args) {
		checkSubsequentString("abcde", "ace");
	}
	
	private static void checkSubsequentString(String input, String seq) {
		int i=0;
		int j=0;
		while(i<input.length() && j<seq.length()) {
			if(input.charAt(i) == seq.charAt(j)) {
				j++;
			}
			i++;
		}
		System.out.println(j==seq.length());
	}

}
