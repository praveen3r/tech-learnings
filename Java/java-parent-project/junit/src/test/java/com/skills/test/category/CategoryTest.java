package com.skills.test.category;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryTest {

	@Test
	@Category(Category1.class)
	public void testAdd(){
		System.out.println("testAdd - Category1");
		assertEquals("Error", 1, 1);
	}
	
	@Test
	public void testNew(){
		System.out.println("testNew - No Category");
	}
}

