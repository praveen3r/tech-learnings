package com.demo.func.interfce;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("line 1");
		// TODO Auto-generated method stub
		TestSampleInterface2 testSampleInterface2 = () -> System.out.println("My Func interface");
		testSampleInterface2.method1();
	}

}
