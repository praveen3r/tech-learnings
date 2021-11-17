package com.demo.string;

import java.util.Arrays;
import java.util.List;

public class TestString {

	public static void main(String[] args) {
		testTransform();

	}
	
	public static void testIndent() {
		String str = "*****\n  Hi\n  \tHello Pankaj\rHow are you?\n*****";

		System.out.println(str.indent(0));
		System.out.println(str.indent(3));
		System.out.println(str.indent(-3));
	}
	
	public static void testTransform() {
		String s = "Hi,Hello,Howdy";
		List strList = s.transform(s1 -> {
						return Arrays.asList(s1.split(","));
							}
						);
		System.out.println(strList);
	}
	
	public static void testTransform2() {
		String str = "1000";
	    Integer integer = str.transform(Integer::parseInt);
	    System.out.println(integer);
	}

}
