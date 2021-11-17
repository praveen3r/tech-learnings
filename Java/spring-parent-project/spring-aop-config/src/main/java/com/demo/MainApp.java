package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("config.xml");
        Car car = (Car) appContext.getBean("car");

        car.drive();
        car.drive(50);


        car.drive();
        //car.drive(50);
		/*FactoryService factoryService = new FactoryService();
		Car car = (Car)factoryService.getBean("car");
		car.drive();*/

        ((ClassPathXmlApplicationContext) appContext).close();
    }

}
