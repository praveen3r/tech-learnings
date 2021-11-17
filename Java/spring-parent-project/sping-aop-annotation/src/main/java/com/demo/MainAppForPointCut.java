package com.demo;

import com.demo.bean.Car;
import com.demo.config.DemoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppForPointCut {

    public static void main(String[] args) {
        //ApplicationContext appContext = new ClassPathXmlApplicationContext("configAnnotation.xml");
        ApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        try {
            Car car = (Car) appContext.getBean("car");

            car.drive();
//		car.drive(50);
//		car.drive("test");
//		car.drive(50,50);

            ((AnnotationConfigApplicationContext) appContext).close();

        } catch (Exception e) {
            System.out.println("exception occured");
        }
    }

}
