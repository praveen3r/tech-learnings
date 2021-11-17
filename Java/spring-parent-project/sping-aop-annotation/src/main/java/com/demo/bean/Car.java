package com.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;

// Configured in App config as bean class.
public class Car {

	@Autowired
	Bike bike;

    public void drive() {
        System.out.println("Driving the Car with speed, returning void");
    }

    public void drive(int speed) {
        System.out.println("Driving the Car with speed " + speed + ", returning void");
    }

    public String driveFast() {
        System.out.println("Driving the Car fast with speed, returning String");
        return "test";
    }

    public String driveFast1() throws Exception {
        System.out.println("Driving the Car fast1 with speed, returning String");
        return "test";
    }

    public String driveFast2(int speed) throws Exception {
        System.out.println("Driving the Car fast12 with speed " + speed + ", returning String");
        return "test";
    }

    public String drive(String test) {
        System.out.println("Driving the Car with speed String" + ", returning String");
        return "test";
    }

    public int drive(int test, int test1) {
        System.out.println("Driving the Car with speed two int" + ", returning int");
        return 2;
    }
    
    public void driveBike() {
		bike.display();
	}
	

    public void stop() {
        System.out.println("stopped the Car");
    }
}
