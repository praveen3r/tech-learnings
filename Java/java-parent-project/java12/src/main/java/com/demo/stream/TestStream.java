package com.demo.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		testTeeing();

	}
	
	public static void testTeeing() {
		double avg = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                		Collectors.summingDouble(i -> i),
                		Collectors.counting(),
                        (sum, n) -> sum / n));

		System.out.println(avg);
	}

}
