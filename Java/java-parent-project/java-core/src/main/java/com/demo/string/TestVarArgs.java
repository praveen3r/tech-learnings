package com.demo.string;

public class TestVarArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display1("1","2");
	}

	public static void display1(String... test){
		System.out.println(test[1]);
	}
}
