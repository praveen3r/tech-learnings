package com.demo.proxy;

import com.demo.Car;
import com.demo.aop.LoggingAspect;

public class CarProxy extends Car{

	public void drive(){
		LoggingAspect loggingAspect = new LoggingAspect();
		loggingAspect.log();
		super.drive();
	}
}
