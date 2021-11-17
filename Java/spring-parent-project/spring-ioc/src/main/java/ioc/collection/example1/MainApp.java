package ioc.collection.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans_Collection.xml");

        //Example 1
        Customer cust = context.getBean("CustomerList", Customer.class);
        System.out.println(cust);

        //Example 2
        Customer cust_ = context.getBean("CustomerBean", Customer.class);
        System.out.println(cust_);
    }
}