package com.skills.test.parameters;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import com.skills.junit.testmethod.Arithmatic;

@RunWith(Parameterized.class)
public class ParameterizedFieldsTest {

	// fields used together with @Parameter must be public
    @Parameter(0)
    public int m1;
    @Parameter(1)
    public int m2;
    @Parameter(2)
    public int result;
    
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }
    
    @Test
    public void multiplyShouldReturn(){
    	Arithmatic arithmatic=new Arithmatic();
    	System.out.println(m1+"*"+m2+"="+result);
    	assertEquals("Multiply shouldn't match",result,arithmatic.multiply(m1, m2));
    }
    
    @BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	
	@Before
	public void before(){
		System.out.println("Before");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
	
	@After
	public void after(){
		System.out.println("After");
	}
}
