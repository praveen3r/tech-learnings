package ioc.lazyloading.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        //Read the configuration file
//        Resource resource = new ClassPathResource("SpringBeans_Lazy.xml");
        //Read all the bean definition
//        BeanFactory bf = new XmlBeanFactory(resource);

        ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringBeans_Lazy.xml");

        //step 1

        //Get the bean1 instance
//        Bean1 bean1=(Bean1)bf.getBean("bean1");
        //Get the bean2 instance
//        Bean2 bean2=(Bean2)bf.getBean("bean2");

    }
}
