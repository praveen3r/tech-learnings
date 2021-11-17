package com.demo.def.interfce;

public interface TestInterface1 {

	void method1(String str);
	
	default void method2(String str){
		System.out.println("I1 logging::"+str);
	}
}
