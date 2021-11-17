package com.demo;

public class Car {


    public void drive() {
        System.out.println("driving the car with speed");
        //System.out.println("loggig from car class");
        System.out.println("driving the car ");
    }

    public void drive(int speed) {
        System.out.println("driving the car with speed " + speed);
    }

    public void stop() {
        System.out.println("stopped the car");
    }
}
