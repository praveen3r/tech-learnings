package ioc.autowiring.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans_AutoWiring.xml");
        EmployeeBean employee = (EmployeeBean)context.getBean("employee");

        System.out.println(employee.getFullName());
        System.out.println(employee.getDepartmentBean().getName());
    }
}
