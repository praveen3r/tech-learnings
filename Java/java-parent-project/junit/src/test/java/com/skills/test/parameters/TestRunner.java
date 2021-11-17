package com.skills.test.parameters;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
	    //Result result = JUnitCore.runClasses(ArithmaticTest.class);
		Result result = JUnitCore.runClasses(TestSuite.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	    System.out.println("Run Test Count : "+result.getRunCount());
	    System.out.println("Run failure Count : "+result.getFailureCount());
	    System.out.println("Ignore Test Count : "+result.getIgnoreCount());
	    System.out.println("All test success : "+result.wasSuccessful());
	  }
}
