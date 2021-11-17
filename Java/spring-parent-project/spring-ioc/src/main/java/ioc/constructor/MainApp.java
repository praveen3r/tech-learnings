package ioc.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Constructor.xml"});
//        ApplicationContext context1 =new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Constructor.xml"});
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(new String[]{"SpringBeans_Constructor.xml"});

//        Foo foo = context.getBean("foo_1",Foo.class);
//        System.out.println(foo);

        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);


    }
}
