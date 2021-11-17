package com.demo.programs;

public class ReversMiddleWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Reverse the character in middle words
		printReverse("Hi How Are You?");
		System.out.println();
		//Reverse all middle letters
		printWithoutApi("Hi How Are You?");
		//Reverse middle characters in a string
		printReverseCharacters("Ragupathy");
	}

	static void printReverse(String str) {
		// Print first word
		int i = 0;
		for (i = 0; i < str.length() && str.charAt(i) != ' '; i++)
			System.out.print(str.charAt(i));

		// Print middle words
		String word = "";

		for (; i < str.length(); i++) {

			if (str.charAt(i) != ' ')
				word += str.charAt(i);

			else {
				System.out.print(new StringBuilder(word).reverse().toString() + " ");
				word = "";
			}
		}

		// Print last word
		System.out.print(word + " ");
	}

	static void printWithoutApi(String s) {
		// Taking an Empty String
		String fst = "";
		int i = 0;
		for (i = 0; i < s.length();) {

			// Iterating from starting index
			// When we get space, loop terminates
			while (s.charAt(i) != ' ') {
				fst = fst + s.charAt(i);
				i++;
			}

			// After getting one Word
			break;
		}
		
		System.out.print(fst);

		// Taking an Empty String
		String last = "";
		int j = 0;
		for (j = s.length() - 1; j >= i;) {

			// Iterating from last index
			// When we get space, loop terminates
			while (s.charAt(j) != ' ') {
				last = s.charAt(j) + last;
				j--;
			}

			// After getting one Word
			break;
		}
		
		for (int m = j; m >= i; m--) {

			// Reversing the left characters
			System.out.print(s.charAt(m));
		}

		// Printing the first word
		System.out.println(last);
	}
	
	static void printReverseCharacters(String input) {
		System.out.print(input.charAt(0));
		for(int i=input.length()-2;i>0;i--) {
			System.out.print(input.charAt(i));
		}
		System.out.print(input.charAt(input.length()-1));
	}
}
