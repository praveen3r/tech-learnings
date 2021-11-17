package com.skills.test.testmethod;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ArithmaticTest.class,
	MultiplicationTest.class
})
public class TestSuite {

}
