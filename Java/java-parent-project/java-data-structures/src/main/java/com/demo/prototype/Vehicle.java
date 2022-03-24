package com.demo.prototype;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Cloneable{

	private List<String> vehicleList;
	
	public Vehicle() {
		
	}

	public Vehicle(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	public void insertData() {
		vehicleList = new ArrayList<String>();
		vehicleList.add("Hyundai i10");
		vehicleList.add("Ford Figo");
		vehicleList.add("Chevrolet Beat");
		vehicleList.add("Audi A4");
	}
	
	public Vehicle clone() {
		List<String> newVehicleList = new ArrayList<String>();
		newVehicleList.addAll(this.vehicleList);
		
		return new Vehicle(newVehicleList);
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleList=" + vehicleList + "]";
	}

	public List<String> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	
	
	
}
