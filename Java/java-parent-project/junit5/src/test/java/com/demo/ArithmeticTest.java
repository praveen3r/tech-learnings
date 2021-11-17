package com.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

@TestInstance(Lifecycle.PER_METHOD)
class ArithmeticTest {
	
	Arithmetic arithmetic= null;
	
	ArithmeticTest(){
		System.out.println("getting called");
	}
	
	@BeforeAll
	static void beforeInstance() {
		System.out.println("before instance");
	}
	
	@BeforeEach
	void initialize(TestInfo testInfo, TestReporter testReporter) {
		arithmetic = new Arithmetic();
		testReporter.publishEntry("test","executing " + testInfo.getDisplayName());
	}

	@Test
	@DisplayName("testing add method")
	void testAdd() {
		int actual = arithmetic.add(1, 1);
		assertEquals(2, actual,()-> "values must b 3");
	}
	
	@Test
	void testDivide() {
		assumeTrue(true);
		assertThrows(ArithmeticException.class, () -> arithmetic.divide(1, 0),"throws an exception");
	}
	
	@Test
	@Disabled
	void testDivide1() {
		assertThrows(ArithmeticException.class, () -> arithmetic.divide(1, 0),"throws an exception");
	}
	
	@Test
	@DisplayName("testing all methods")
	void testAssertAll() {
		assertAll(
				()-> assertEquals(2, arithmetic.add(1, 1),"values must b 3"),
				()-> assertEquals(3, arithmetic.add(1, 2),"values must b 3")
				);
	}
	
	@DisplayName("testing repeated")
	@RepeatedTest(3)
	void testRepated(RepetitionInfo repetitionInfo) {
		System.out.println(repetitionInfo.getCurrentRepetition());
		int actual = arithmetic.add(1, 1);
		assertEquals(2, actual,()-> "values must b 3");
	}
	
	@Nested
	class nestedTest{
		
		@Test
		@DisplayName("testing add method")
		void testAdd() {
			int actual = arithmetic.add(1, 1);
			assertEquals(2, actual,"values must b 3");
		}
		
		@Test
		void testDivide() {
			assumeTrue(true);
			assertThrows(ArithmeticException.class, () -> arithmetic.divide(1, 0),"throws an exception");
		}
	}
	
	@Test
	@DisplayName("testing tags")
	@Tag("run")
	void testTag() {
		assertTrue(true);
	}

}
