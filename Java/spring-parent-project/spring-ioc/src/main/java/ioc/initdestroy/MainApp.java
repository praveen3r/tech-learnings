package ioc.initdestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Concepts.xml"});

        NetworkManager networkMng = (NetworkManager) context.getBean("netManager");
        networkMng.readData();


    }
}
