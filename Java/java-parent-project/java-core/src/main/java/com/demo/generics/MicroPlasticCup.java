package com.demo.generics;

public class MicroPlasticCup  extends Plastic implements ILiquid{

	@Override
	public String taste() {
		return "Worst taste";
	}
}
