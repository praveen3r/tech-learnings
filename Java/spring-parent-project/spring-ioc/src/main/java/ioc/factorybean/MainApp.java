package ioc.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String str[]) {


        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans_FactoryBean.xml");

        Employee manager = (Employee) context.getBean("manager");
        System.out.println(manager);

        Employee director = (Employee) context.getBean("director");
        System.out.println(director);

    }
}
