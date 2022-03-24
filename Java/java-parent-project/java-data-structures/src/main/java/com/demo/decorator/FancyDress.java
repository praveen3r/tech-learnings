package com.demo.decorator;

public class FancyDress extends DressDecorator {

	public FancyDress(Dress dress) {
		super(dress);
	}

	public void assemble() {
		super.assemble();
		System.out.println("assembling fancy dress");
	}
	
	
}
