package com.demo.local.variable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestLocalVar {

	public static void main(String[] args) {
		test1();

	}
	
	public static void test1() {
		var testStr = "Sample.txt";
		var testInt = 1;
		var testLong= 1l;
		var testDouble = 1.0;
		var testBoolean = true;
		var list = new ArrayList<String>(); 
		var map1 = new HashMap(); // Inferred as HashMap
		var map2 = new HashMap<>(); // Inferred as HashMap<Object, Object>
	}
	
	public static void test2() {
		var numbers = List.of(1, 2, 3, 4, 5); // inferred value ArrayList<String>
		// Index of Enhanced For Loop
		for (var number : numbers) {
			System.out.println(number);
		}
		// Local variable declared in a loop
		for (var i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		numbers.forEach(System.out::println);
	}
	
	private static void readFile() throws IOException {
		var fileName = "Sample.txt";
		var line = "";
		var fileReader = new FileReader(fileName);
		var bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();
	}
	
	private static void anonymousClassTypes() {
		var runnable = new Runnable() {
			@Override
			public void run() {
				var numbers = List.of(5, 4, 3, 2, 1);
				for (var number : numbers) {
					System.out.println(number);
				}
			}
		};
	}

	private static void nonDenotableTypes1() {
		var map3 = new HashMap<>() { // anonymous class
			int someVar;
		};
	}
	
	private static void nonDenotableTypes2() {
		// Special Case Non-Denotable Type
		var person = new Object() {
			class Name {
				String firstName;
				String lastName;
				public Name(String firstName, String lastName) {
					super();
					this.firstName = firstName;
					this.lastName = lastName;
				}
				public String getFirstName() {
					return firstName;
				}
				public void setFirstName(String firstName) {
					this.firstName = firstName;
				}
			}
			Name name;
			public String displayName() {
				return name.getFirstName() + " " + name.lastName;
			}
		};
		person.name = person.new Name("Rakesh", "Kumar");
		System.out.println(person.displayName());
	}
}
