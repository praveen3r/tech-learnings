package com.demo.decorator;

public class SportyDress extends DressDecorator {

	public SportyDress(Dress dress) {
		super(dress);
	}

	public void assemble() {
		super.assemble();
		System.out.println("assembling Sporty dress");
	}
}
