package com.demo.regex;

public class TestRegex {
	
	static String testStr="";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/* . : Matches any one character
		testStr = "T";
		System.out.println(testStr.matches("."));*/
		
		/* ^regex : Finds regex that must match at the beginning of the line.
		testStr = "T";
		System.out.println(testStr.matches("^T"));*/
		
		/* regex$ : Finds regex that must match at the end of the line.
		testStr = "T";
		System.out.println(testStr.matches("T$"));*/
		
		/* [abc] : Set definition, can match the letter a or b or c.
		testStr = "t";
		System.out.println(testStr.matches("[t]"));*/ 
		 
		
		/* [abc][vz] :Set definition, can match a or b or c followed by either v or z.
		testStr = "te";
		System.out.println(testStr.matches("[t][e]"));*/
		
		/*[^abc] : When a caret appears as the first character inside square brackets, it negates the pattern. This pattern matches any character except a or b or c.
		testStr = "te";
		System.out.println(testStr.matches("[^afg][^tr]"));*/
		
		/*[a-d1-7] : Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.
		 testStr = "t";
		System.out.println(testStr.matches("[a-t]"));*/
		
		/* X|Z : Finds X or Z.
		 testStr = "t";
		System.out.println(testStr.matches("t|Z"));*/
		
		/*XZ : Finds X directly followed by Z.
		 testStr = "te";
		System.out.println(testStr.matches("te"));*/
		
		/* $ : Checks if a line end follows. */
		 
		
		/*
		Regular Expression
		 \d                       Any digit, short for [0-9]
		 \D                       A non-digit, short for [^0-9]
         \s                       A whitespace character, short for [ \t\n\x0b\r\f]
         \S                       A non-whitespace character, short for
         \w                       A word character, short for [a-zA-Z_0-9]
         \W                       A non-word character [^\w]
         \S+                      Several non-whitespace characters
         \b                       Matches a word boundary where a word character is [a-zA-Z0-9_]
         
         testStr = "te";
		System.out.println(testStr.matches("\\D+"));
		
		testStr = "te";
		System.out.println(testStr.matches("\\w+"));
		
		
		Regular Expression	Description	Examples
		
		 *					Occurs zero or more times, is short for {0,}
							X* finds no or several letter X, <sbr /> .* finds any character sequence
							
		
		+					Occurs one or more times, is short for {1,}
							X+- Finds one or several letter X
							
		
		?					Occurs no or one times, ? is short for {0,1}.
							X? finds no or exactly one letter X
							
		
		{X}					Occurs X number of times, {} describes the order of the preceding liberal
							\d{3} searches for three digits, .{10} for any character sequence of length 10.
							

		{X,Y}				Occurs between X and Y times,
							\d{1,4} means \d must occur at least once and at a maximum of four.
							

		 *?					? after a quantifier makes it a reluctant quantifier. It tries to find the smallest match. 
		 					This makes the regular expression stop at the first match.
		
		testStr = "te";
		System.out.println(testStr.matches("t\\w+"));
		
		testStr = "te";
		System.out.println(testStr.matches("t\\w*"));
		
		testStr = "te";
		System.out.println(testStr.matches("t\\w{1,3}"));
		
		testStr = "bad";
		System.out.println(testStr.matches("b(a|e|i)d"));
		 */
		/*
		 You can group parts of your regular expression. In your pattern you group elements with round brackets, e.g., (). This allows you to assign a repetition operator to a complete group.

		In addition these groups also create a back reference to the part of the regular expression. This captures the group. A back reference stores the part of the String which matched the group. This allows you to use this part in the replacement.
		
		Via the $ you can refer to a group. $1 is the first group, $2 the second, etc.
		
		Let’s, for example, assume you want to replace all whitespace between a letter followed by a point or a comma. This would involve that the point or the comma is part of the pattern. Still it should be included in the result.
		
		// Removes whitespace between a word character and . or ,
		String pattern = "(\\w)(\\s+)([\\.,])";
		System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));
		This example extracts the text between a title tag.
		
		
*/
		/*
		testStr = "bad";
		System.out.println(testStr.matches(".*a.*"));*/
		
		/*testStr = "9742221004";
		System.out.println(testStr.matches("[9]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));
		 */
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		/**/
		testStr = "<test>123</test>";
		System.out.println(testStr.matches("<test>.*</test>"));
		testStr=testStr.replace("<test>.*</test>","123");
		System.out.println(testStr);
		
		
	}

}
