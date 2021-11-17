package com.demo.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestOptionalChaining {

	public static void main(String[] args) {

		testOptional5();		
		
	}
	
	private static void testOptional1() {
		ClassA classAObj = new ClassA();
		System.out.println(
				Optional.ofNullable(classAObj.getClassBObj())
				.map(ClassB::getClassCObj)
				.isPresent());
	}
	
	private static void testOptional2() {
		ClassA classAObj = new ClassA();
		ClassB classBObj = new ClassB();
		classAObj.setClassBObj(classBObj);
		System.out.println(
				Optional.ofNullable(classAObj.getClassBObj())
				.map(ClassB::getClassCObj)
				.isPresent());
	}
	
	private static void testOptional3() {
		ClassA classAObj = new ClassA();
		ClassB classBObj = new ClassB();
		ClassC classCObj = new ClassC();
		classBObj.setClassCObj(classCObj);
		classAObj.setClassBObj(classBObj);
		System.out.println(
				Optional.ofNullable(classAObj.getClassBObj())
				.map(ClassB::getClassCObj)
				.isPresent());
	}
	
	private static void testOptional4() {
		System.out.println("Coming here");
		ClassA classAObj = new ClassA();
				Stream.ofNullable(classAObj.getClassBObj())
				.map(ClassB::getClassCObj)
				.map(ClassC::getDemoList)
				.flatMap(s -> s.stream())
				.forEach(System.out::println);
	}
	
	private static void testOptional5() {
		System.out.println("Coming here1");
		ClassA classAObj = new ClassA();
		ClassB classBObj = new ClassB();
		ClassC classCObj = new ClassC();
		List<String> testList = List.of("test1","test2","test3");
		classCObj.setDemoList(testList);
		classBObj.setClassCObj(classCObj);
		classAObj.setClassBObj(classBObj);
				Stream.ofNullable(classAObj.getClassBObj())
				.map(ClassB::getClassCObj)
				.map(ClassC::getDemoList)
				.flatMap(s -> s.stream())
				.forEach(System.out::println);
	}

}
