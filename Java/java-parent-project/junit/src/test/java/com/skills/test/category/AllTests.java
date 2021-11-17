package com.skills.test.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@ExcludeCategory(Category2.class)
@IncludeCategory(Category1.class)
@SuiteClasses({ CategoryTest.class, CategoryTest2.class })
public class AllTests {

}
