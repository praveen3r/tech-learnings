package com.skills.test.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({Category1.class,Category2.class})
public class CategoryTest2 {
	
	@Test
	public void testAddCat2(){
		System.out.println("testAddCat2");
	}

}
