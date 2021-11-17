package com.demo;

import com.demo.bean.Bike;
import com.demo.bean.Car;
import com.demo.config.DemoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        //TODO : with the xml config file.
        //ApplicationContext appContext = new ClassPathXmlApplicationContext("configAnnotation.xml");

        //TODO : with the Annotation Class as config.
        ApplicationContext appContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        try {
            //TODO : loading the Car through @bean
            System.out.println("##################### @bean ###########################");
            Car car = (Car) appContext.getBean("car");
            car.drive();
            //car.drive();
            
            /*System.out.println("##################### @configurable ###########################");
            Car car1 = new Car();
            car1.driveBike();*/

            car.drive(50);
//            car.driveFast();
//            car.driveFast1();
//            String result = car.driveFast2(50);
//            System.out.println("result in main class " + result);

            //TODO : loading the Bike through @Component
            System.out.println("#################### @Component ############################");
            Bike bike = (Bike) appContext.getBean("bike");
            bike.display();


            ((AnnotationConfigApplicationContext) appContext).close();
        } catch (Exception e) {
            System.out.println("exception occured");
        }
    }

}
