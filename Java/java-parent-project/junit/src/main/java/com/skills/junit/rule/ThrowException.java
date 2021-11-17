package com.skills.junit.rule;

public class ThrowException {

	public int throwIllegalException(int a){
		int result=a;
		if(a<0){
			throw new IllegalArgumentException("Negative value not allowed");
		}
		return result;
	}
}
