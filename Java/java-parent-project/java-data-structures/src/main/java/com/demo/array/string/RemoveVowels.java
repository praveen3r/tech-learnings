package com.demo.array.string;

import java.util.Set;

public class RemoveVowels {

	public static void main(String[] args) {
		removeVowels("Hello World");
	}
	
	private static void removeVowels(String inputStr) {
		Set<Character> set = Set.of('a','e','i','o','u');
		StringBuilder sb = new StringBuilder();
		for(char ch: inputStr.toCharArray()) {
			if(!set.contains(ch)) {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}

}
