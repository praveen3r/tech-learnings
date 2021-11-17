package com.skills.junit.mockito;

public class Arithmatic {
	private int a;
	private int b;
	
	public int add(int a,int b){
		return a+b;
	}
	
	public int multiply(int a,int b){
		return a*b;
	}
	
	public void setValues(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	public int addDefault(){
		return this.a+this.b;
	}
	
	public static int addStatic(int a,int b){
		return a+b;
	}

}
