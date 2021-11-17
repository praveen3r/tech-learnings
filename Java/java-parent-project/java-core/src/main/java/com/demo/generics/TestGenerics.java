package com.demo.generics;

public class TestGenerics {

	public static void main(String[] args) {
		earlier() ;
	}
	
	public static void earlier() {
		Glass glass = new Glass();
		Juice juice = new Juice();
		Water water = new Water();
		
		glass.liquid = juice;
		glass.liquid = water;
		
		//retrieve
		Juice juice1 =(Juice) glass.liquid;
	}
	
	public static void now() {
		Glass<Juice> glass = new Glass<Juice>();
		Juice juice = new Juice();
		
		glass.liquid = juice;
		
		//retrieve (no need type casting)
		Juice juice1 = glass.liquid;
	}
	
	public static void multipleClassType() {
		//Color<Red, Blue, Green> color = new Color<Red, Blue, Green>();
		
		Color<Red, Blue, Green> color = new Color<>();
	}
	
	public static void methodType() {
		Juice juice = new Juice();
		Water water = new Water();
		
		Bar bar = new Bar();
		//bar.mix(juice, water);
		bar.<Juice, Water>mix(juice, water);
	}
	
	public static void boundedClassType() {
		JuiceCup juice = new JuiceCup();
		WaterCup water = new WaterCup();
		
		Cup<JuiceCup> cup = new Cup<>();
		cup.taste();
		
	}
	
	public static void multipleBoundedClassType() {
		
		//PlasticCup<PlasticCup> cup = new PlasticCup<MicroPlasticCup>();
		
		PlasticCup<MicroPlasticCup> cup = new PlasticCup<>();
		cup.taste();
		
	}
	
	public static void boundedMethodType() {
		JuiceCup juice = new JuiceCup();
		
		Bar bar = new Bar();
		bar.mixPropertly(juice);
		bar.<JuiceCup> mixPropertly(juice);
	}
	
	public static void wildCards() {
		Tray tray = new Tray();
		
		tray.addGlass(new Glass<String>());
		tray.addGlass(new Glass<Integer>());
		//tray.addGlass(new Glass<?>()); Wildcard ? not allowed while initializing
		
		tray.addGlassJuice(new Glass<Juice>());
		
		//tray.addCup(new PlasticCup<>());
		
		//tray.addAnyCup(new PlasticCup<>());
		
		tray.addPlasticCup(new PlasticCup<>());
		
		
	}

}
