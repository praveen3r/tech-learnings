package com.skills.test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestSuite1.class);

      //Custom testsuite and results
      /*TestSuite testSuite=new TestSuite(TestEmployee.class,TestEmployee1.class);
      TestResult result1=new TestResult();
      testSuite.run(result1);*/
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      /*while(result1.failures().hasMoreElements()){
    	  System.out.println(result1.failures().nextElement().exceptionMessage());
      }*/
      System.out.println("Total TestCases: "+result.getRunCount());
      System.out.println("Total Ignore Cases: "+result.getIgnoreCount());
      System.out.println("Total failure cases: "+result.getFailureCount());
      System.out.println("Total run time: "+result.getRunTime());
      System.out.println(result.wasSuccessful());
   }
}