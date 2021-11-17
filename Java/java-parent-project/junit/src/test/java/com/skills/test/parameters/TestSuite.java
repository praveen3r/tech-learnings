package com.skills.test.parameters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ParameterizedFieldsTest.class,
	ParameterizedUsingConstructorTest.class
})
public class TestSuite {

}
