package com.demo.decorator;

public class ModernDress extends DressDecorator {

	public ModernDress(Dress dress) {
		super(dress);
	}
	
	public void assemble() {
		super.assemble();
		System.out.println("assembling Modern dress");
	}

}
