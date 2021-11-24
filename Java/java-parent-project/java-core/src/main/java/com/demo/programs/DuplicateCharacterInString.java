package com.demo.programs;

import java.util.Optional;

public class DuplicateCharacterInString {

	public static void main(String[] args) {
		String str = "Hiir";
		getCharCount(str);
	}

	private static void getCharCount(String str) {
		if (Optional.ofNullable(str).isPresent() && !str.isEmpty()) {
			for (int index = 0; index < str.length(); index++) {
				char ch = str.charAt(index);
				for (int index1 = index + 1; index1 < str.length(); index1++) {
					char ch1 = str.charAt(index1);
					if (ch == ch1) {

						String str1 = Character.toString(ch);
						System.out.println("char is " + str1);
						break;
					}
				}
			}
		}
	}
}
