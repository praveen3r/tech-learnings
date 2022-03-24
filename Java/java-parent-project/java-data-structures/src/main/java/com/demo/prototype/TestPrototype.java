package com.demo.prototype;

public class TestPrototype {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.insertData();
		
		System.out.println(vehicle);
		
		Vehicle vehicle1 = vehicle.clone();
		vehicle1.getVehicleList().add("Volkswogon Polo");
		
		System.out.println(vehicle1);
		
		System.out.println(vehicle);
	}

}
