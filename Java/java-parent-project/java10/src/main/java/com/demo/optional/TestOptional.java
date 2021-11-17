package com.demo.optional;

import java.util.stream.Stream;

public class TestOptional {

	public static void main(String[] args) {
		testOrElseThrow();

	}

	private static void testOrElseThrow() {
		String result = Stream.of("outlet", "puddle", "eraser")
                .filter(s -> Character.isDigit(s.charAt(0)))
                .findAny()
                .orElseThrow();
		System.out.println(result);
	}
	
	
}
