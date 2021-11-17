package com.demo.def.interfce;

public class TestClass implements TestInterface,TestInterface1{
	@Override
	public void method1(String str) {
		System.out.println("Overriding str");
	}
	
	public void method3(String str) {
		TestInterface.method3(str);
	}
	
	
	@Override
	public void method2(String str) {
		System.out.println("MyClass logging::"+str);
		TestInterface.super.method2(str);
	}
	public static void main(String args[]){
		TestClass testClass = new TestClass();
		testClass.method1("1");
		testClass.method2("Prav");
		testClass.method3("Prav1");
	}
}
