package com.demo.func.interfce;


@FunctionalInterface
public interface TestSampleInterface2 extends TestSampleInterface1,TestSampleInterface{
	 public void method1();
	 default void method2(String str){
			System.out.println("TestSampleInterface logging::"+str);
		}
	 
}
