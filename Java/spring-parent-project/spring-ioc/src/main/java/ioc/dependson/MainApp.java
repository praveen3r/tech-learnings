package ioc.dependson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Depends-on.xml"});
//        System.out.println(context.getBean("testA", A.class).b);
    }
}
