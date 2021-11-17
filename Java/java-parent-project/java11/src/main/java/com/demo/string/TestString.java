package com.demo.string;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestString {

	public static void main(String[] args) {
		testAsMatchPredicate();
	}
	
	public static void testEmpty() {
		String str = null;
		String str1 = "";
		//System.out.println(str.isEmpty());
		System.out.println(str1.isEmpty());
	}
	
	public static void testBlank() {
		String str = null;
		String str1 = " ";
		System.out.println(str1.isBlank());
		//System.out.println(str.isBlank());
		
	}
	
	public static void testLines() {
		String str = "Test1\nTest2\nTest3"; 
        System.out.println(str.lines().collect(Collectors.toList())); 
	}
	
	public static void testRepeat() {
		String str = "HelloWorld"; 
        System.out.println(str.repeat(4));
	}
	
	public static void testStripLeading() {
		String str = " GeeksForGeeks"; 
        System.out.println(str.stripLeading()); 
	}
	
	public static void testStripTrailing() {
		String str = "GeeksForGeeks "; 
        System.out.println(str.stripTrailing()); 
	}
	
	public static void testStrip() {
		String str = " GeeksForGeeks "; 
        System.out.println(str.strip()); 
	}
	
	public static void testStrip1() {
		 String str = "\t abc \n";
		 System.out.println(str.strip());
		 System.out.println(str.trim());
	}
	
	public static void testStrip2() {
		Character c = '\u2000';
        String s = c + "abc" + c;

        System.out.println(Character.isWhitespace(c));
        System.out.println(s.trim());
        System.out.println(s.strip());
	}
	
	public static void testAsMatchPredicate() {
		var str = Pattern.compile("aba").asMatchPredicate();
		System.out.println(str.test("aabb"));
	}

}
