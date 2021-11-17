package com.demo.others;

import java.text.NumberFormat;
import java.util.Locale;

public class TestOthers {

	public static void main(String[] args) {
		testNumberFormatting();
	}

	
	public static void testNumberFormatting() {
		System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        upvotes.setMaximumFractionDigits(1);

        System.out.println(upvotes.format(2592678) + " upvotes");


        NumberFormat upvotes2 = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        upvotes2.setMaximumFractionDigits(2);
        System.out.println(upvotes2.format(2011) + " upvotes");
	}
	
	public static void testInstanceOf() {
		String str = new String("checking instance");
		
		/*
		 * if (str instanceof String s) { System.out.println(s); }
		 */
		 
	}
}
