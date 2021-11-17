package ioc.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans_AutoWiring.xml");
        A a = context.getBean("a", A.class);
        a.display();

        //C c = context.getBean("c", C.class);
        //System.out.println(c.getA1());
        //System.out.println(c.getA2());
    }
}
