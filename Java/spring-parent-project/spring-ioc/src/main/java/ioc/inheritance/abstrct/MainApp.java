package ioc.inheritance.abstrct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String str[]) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Inheritance.xml"});

        //TODO:Error while creating the bean factor for abstract class or interface
//        context.getBean("inheritedTestBean", TestBean.class);
        /**
         * Exception in thread "main" org.springframework.beans.factory.BeanIsAbstractException:
         *         Error creating bean with name 'inheritedTestBean': Bean definition is abstract
         */

        DerivedTestBean derivedTestBean = context.getBean("inheritsWithDifferentClass", DerivedTestBean.class);
        System.out.println(derivedTestBean);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
