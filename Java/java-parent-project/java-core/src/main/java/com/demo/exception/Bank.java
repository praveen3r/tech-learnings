package com.demo.exception;

public class Bank {

	public void exceptionWithTryCatch(){
		try{
			System.out.println(1/0);
		}catch(Exception e){
			System.out.println("Exception caught");
		}
		System.out.println("coming here");
	}
	
	public void exceptionWithThrows() throws Exception{
		System.out.println(1/0);
		System.out.println("coming here");
	}
}
