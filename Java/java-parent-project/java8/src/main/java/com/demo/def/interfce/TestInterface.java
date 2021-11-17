package com.demo.def.interfce;

public interface TestInterface {

	void method1(String str);
	
	default void method2(String str){
		System.out.println("I1 logging::"+str);
	}
	
	/*void method3(String str){
		System.out.println("Interface method3");
	}*/
	
	static void method3(String str){
		System.out.println("Interface method3");
	}
}
