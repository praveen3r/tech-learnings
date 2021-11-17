package com.demo.lambda;

public class TestLambda {

	public static void main(String[] args) {

		//With Single line lambda - example 1
		TestLambdaInterface lambda1 = () -> System.out.println("my first lambda");
		lambda1.display();
		
		//With Single line lambda - example 2
		TestLambdaInterface lambda2 = () -> System.out.println("my second lambda");
		lambda2.display();
		
		//With multi line lambda - curly brances mandatory
		TestLambdaInterface lambda3 = () -> {
			System.out.println("my first multiline lambda");
			System.out.println("my second multiline lambda");
		};
		lambda3.display();
		
		//Pass args and rtn
		TestLambdaInterfaceWithArgs lambda4 = (String str) -> System.out.println("Upper case is->" + str.toUpperCase());
		lambda4.convertUpper("my first args lambda");
		
		//Pass args - no need to mention type as an argument
		TestLambdaInterfaceWithArgs lambda5 = (str) -> System.out.println("Upper case is->" + str.toUpperCase());
		lambda5.convertUpper("my second args lambda");
		
		//Pass args - if it is one argument no need brackets
		TestLambdaInterfaceWithArgs lambda6 = str -> System.out.println("Upper case is->" + str.toUpperCase());
		lambda6.convertUpper("my third args lambda");
				
		//Pass args and rtn
		TestLambdaInterfaceWithArgsAndRtn lambda7 = (String str) -> str.length(); 
		System.out.println("lambda4.getLength(\"my first args with rtn lambda\")->" + lambda7.getLength("my first args with rtn lambda"));
		
		//Pass lambda as argument
		TestLambdaInterfaceWithArgsAndRtn lambda8 = str -> str.length();
		System.out.println("lambda as argument "+getLength(lambda8));
		
	}
	
	public static int getLength(TestLambdaInterfaceWithArgsAndRtn args) {
		return args.getLength("my fourth args lambda");
	}

}
