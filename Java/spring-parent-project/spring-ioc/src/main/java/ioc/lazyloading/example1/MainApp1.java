package ioc.lazyloading.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp1 {

    public static void main(String str[]) {
        //Read the configuration file
        ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringBeans_Lazy.xml");

        //step 1 - dont create any bean through code see what it prints

        //TODO : dont create the bean here.

        //step 2 - create the bean and see the console what it prints.
        //TODO : create the bean here.
        //Get the bean1 instance
         Bean1 bean1=(Bean1)appContext.getBean("bean1");
        //Get the bean2 instance
         Bean2 bean2=(Bean2)appContext.getBean("bean2");


    }
}
