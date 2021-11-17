package com.demo.others;

import java.text.NumberFormat;
import java.util.Locale;

public class TestOthers {

	public static void main(String[] args) {
		testSwitch();
	}

	public static void testSwitch() {
		var day = "MONDAY";
		int numLetters = switch (day) {
		case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
		case "TUESDAY" -> 7;
		case "THURSDAY", "SATURDAY" -> 8;
		case "WEDNESDAY" -> 9;
		default -> throw new IllegalStateException("Huh? " + day);
		};
		
		System.out.println(numLetters);
	}
	
	
}
