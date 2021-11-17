package com.demo.generics;

public class Tray {

	public void addGlass(Glass<?> glass) {
	}
	
	public void addGlassJuice(Glass<Juice> glass) {
	}
	
	public void addCup(Cup<?> cup) {
		cup.taste();
	}
	
	public void addAnyCup(Cup<? extends Cup> cup) {
		cup.taste();
	}
	
	public void addPlasticCup(PlasticCup<? extends ILiquid> cup) {
		cup.taste();
	}
	
	/*
	 * public void addPlasticCupSuper(PlasticCup<? super PlasticCup> cup) {
	 * cup.taste(); }
	 */
}
