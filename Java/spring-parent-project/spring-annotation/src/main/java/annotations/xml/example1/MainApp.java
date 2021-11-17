package annotations.xml.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext(
                "Spring_Annotation.xml");

        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);
    }
}
