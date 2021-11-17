package com.demo.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.demo.dto.TestHibernateAnnotation;

import static org.junit.Assert.*;

public class HibernateValidatorTest {

	private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void testContactSuccess() {
    	TestHibernateAnnotation test = new TestHibernateAnnotation();
    	/*test.setId("123");
    	test.setName("123");;*/
        Set<ConstraintViolation<TestHibernateAnnotation>> violations = validator.validate(test);
        assertTrue(violations.isEmpty());
    }
}
