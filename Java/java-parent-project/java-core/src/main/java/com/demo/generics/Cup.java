package com.demo.generics;

public class Cup<T extends ILiquid> {

	T liquid;
	
	public String taste() {
		return liquid.taste();
	}
}
