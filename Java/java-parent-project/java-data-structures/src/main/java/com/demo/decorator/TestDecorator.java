package com.demo.decorator;

public class TestDecorator {

	public static void main(String[] args) {
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println("sportyDress is finished" + "\n");
		
		Dress modernDress = new ModernDress(new BasicDress());
		modernDress.assemble();
		System.out.println("modernDress is finished" + "\n");
		
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble(); 
		System.out.println("fancyDress is finished" + "\n");
		
		Dress fancySportyDress = new FancyDress(new SportyDress(new BasicDress()));
		fancySportyDress.assemble();
		System.out.println("fancySportyDress is finished" + "\n");
		
		Dress fancyModernDress = new FancyDress(new ModernDress(new BasicDress()));
		fancyModernDress.assemble();
		System.out.println("fancyModernDress is finished" + "\n");
	}

}
