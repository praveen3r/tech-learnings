package com.demo.methodRef;

import java.util.function.BiFunction;

public class TestMethodReference2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BiFunction<String,  String,String> strFunc = Util1::append; 
	    String name ="java";
	    String s=  strFunc.apply(name,"hi"); 
	    System.out.println(s);
	  }
	}
	
class Util1{
	  public static String append(String s1,String s2){
	    return s1+s2;
	  }  
	}