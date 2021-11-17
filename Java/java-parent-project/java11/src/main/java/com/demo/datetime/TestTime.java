package com.demo.datetime;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestTime {

	public static void main(String[] args) {
		testTime();

	}
	
	public static void testTime() {
		TimeUnit c = TimeUnit.DAYS;
		System.out.println(c.convert(Duration.ofHours(24)));
		System.out.println(c.convert(Duration.ofHours(50)));
	}

}
