package com.demo.optional;

import java.util.List;
import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		testEmpty();
	}
	
	public static void testEmpty() {
		String str = "";
		Optional<String> opt = Optional.ofNullable(str);
		System.out.println(opt.isEmpty());
		
		List<String> list = null;
		Optional<List<String>> opt1 = Optional.ofNullable(list);
		System.out.println(opt1.isEmpty());
	}
}
