package ioc.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans_Inheritance.xml"});

        //EXAMPLE 01
//        Employee myEmp1 = (Employee) context.getBean("baseEmployeeBean1");
//        System.out.println(myEmp1.hashCode());
//        System.out.println(myEmp1.toString());
//        System.out.println(myEmp1.NAME);

//        TODO: check for deep clone.
        Employee myEmp2 = (Employee) context.getBean("myEmployeeBean1");
        System.out.println(myEmp2.hashCode());
        System.out.println(myEmp2.toString());
        System.out.println(myEmp2.NAME);


        Supervisor supervisor = context.getBean("supervisorBean1", Supervisor.class);
        System.out.println(supervisor.toString());

        //EXAMPLE 02
//        Employee myEmp = (Employee) context.getBean("baseEmployeeBean2");
//        System.out.println(myEmp.toString());
//        System.out.println(myEmp.NAME);
//
//
//        Employee myEmp2 = (Employee) context.getBean("myEmployeeBean2");
//        System.out.println(myEmp2.toString());

        //EXAMPLE 03

        //Employee myEmp3 = (Employee) context.getBean("myEmployeeBean3");
        //System.out.println(myEmp3.toString());

    }
}
