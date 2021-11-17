package com.demo.methodRef;

import java.util.function.BiFunction;

public class TestMethodReference3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 new Util3();
	  }
	}
	
class Util3 extends ParentUtil{
	  
	  public Util3(){
	    BiFunction<String,  String,String> strFunc = this::append; 
	    String name ="java";
	    String s=  strFunc.apply(name," hi"); 
	    System.out.println(s);
	    
	    strFunc = Util3.super::append; 
	    name ="java";
	    s=  strFunc.apply(name," Java Lambda Tutorial"); 
	    System.out.println(s);

	  }
	  
	  @Override
	  public String append(String s1,String s2){
	    System.out.println("child append");
	    return s1+s2;
	  }  
	}
	
	
class ParentUtil{
	  public String append(String s1,String s2){
	    System.out.println("parent append");
	    return s1+s2;
	  }  
	}
