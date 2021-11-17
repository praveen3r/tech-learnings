package ioc.constructor.ambiguities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context =new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Constructor.xml"});
        //prints the default constructor injections as first
        Customer cust = (Customer)context.getBean("CustomerBean");
        System.out.println(cust);

    }
}
