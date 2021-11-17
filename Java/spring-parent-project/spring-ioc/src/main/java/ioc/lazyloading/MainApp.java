package ioc.lazyloading;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Lazy.xml"});
        ApplicationContext ctx = new AnnotationConfigApplicationContext(new String[]{"SpringBeans_Lazy.xml"});

        System.out.println("Bean Factory Initialized !!");

        EmployeeManager empManager = ctx.getBean(EmployeeManager.class);
        Employee emp = empManager.create();

        System.out.println(emp);
    }
}
