package com.demo.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterWithMaxCountInString {

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		countAndPrintUsingMap("bbaac");
		System.out.println(" Time is: " + (System.currentTimeMillis() - start));
		// countAndPrintUsingJava8("ragupathy");
	}

	public static void countAndPrintUsingMap(String input) {

		HashMap<Character, Integer> counter = new HashMap<>();
		int count = 1;
		char result = ' ';
		for (char ch : input.toCharArray()) {
			if (!counter.containsKey(ch)) {
				counter.put(ch, 1);
				
			} else {
				int tempCount = counter.get(ch) + 1;
				counter.put(ch, tempCount);
				if (count < tempCount) 
					count = tempCount;
				
			}
		}
		 for (Map.Entry<Character, Integer> entry : counter.entrySet())
	           if(entry.getValue() == count) {
	        	   result = entry.getKey();
	        	   break;
	           }
	        	   
		System.out.println("the count is " + counter);
		System.out.println("the variable is " + result);
	}

	public static void countAndPrintUsingJava8(String input) {
		Long start = System.currentTimeMillis();
		Map<String, Long> countMap = Stream.of(input.toLowerCase().split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countMap + " Time: " + (System.currentTimeMillis() - start));
	}

	public static void countAndPrintLeastAscii(String str) {

		int count[] = new int[256];

		int len = str.length();

		// Initialize count array index
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;

		int countNew = 0;
		char result = ' ';
		for (int i = 0; i < len; i++) {
			int charCount = count[str.charAt(i)];
			if (countNew < charCount) {
				countNew = charCount;
				result = str.charAt(i);
			}
		}
		System.out.println("Character is " + result);

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			int charCount = count[ch];
			if (charCount == countNew && ch != result) {

				if (ch < result)
					result = ch;
			}

		}
		System.out.println("Character is " + result);
		// Create an array of given String size
		/*
		 * char ch[] = new char[str.length()]; for (int i = 0; i < len; i++) { ch[i] =
		 * str.charAt(i); int find = 0; for (int j = 0; j <= i; j++) {
		 * 
		 * // If any matches found if (str.charAt(i) == ch[j]) find++; }
		 * 
		 * if (find == 1) System.out.println( "Number of Occurrence of " + str.charAt(i)
		 * + " is:" + count[str.charAt(i)]); }
		 */
	}
}
