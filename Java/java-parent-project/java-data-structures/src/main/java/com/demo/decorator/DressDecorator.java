package com.demo.decorator;

public class DressDecorator implements Dress {

	Dress dress;
	
	public DressDecorator(Dress dress) {
		this.dress = dress;
	}
	
	@Override
	public void assemble() {
		this.dress.assemble();

	}

}
