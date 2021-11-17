package com.skills.test.basic;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(MyTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	    System.out.println("Success: "+result.wasSuccessful());
	    System.out.println("Count: "+result.getRunCount());
	    System.out.println("Failures: "+result.getFailureCount());
	    System.out.println("Ignores: "+result.getIgnoreCount());
	  }
}
