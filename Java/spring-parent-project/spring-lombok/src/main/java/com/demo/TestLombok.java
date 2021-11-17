package com.demo;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestLombok {

	public static void main(String[] args) {

		/*Person person = new Person();
		person.setAge(22);
		person.setCompany("test");
		person.setName("test");*/
		//Person person = new Person;
		//Person person = Person.builder().age(22).company("test").build();
		//System.out.println(person.toString());
		//NonNullExample(null);
		//log.info("test log");
		
	}
	
	private static void NonNullExample(@NonNull String name){
		System.out.println(name);
	}

}
