package com.demo.generics;

//if extends class, it should come first and then interface.
public class PlasticCup<T extends Plastic & ILiquid> {

	T liquid;
	
	public String taste() {
		return liquid.taste();
	}
}
