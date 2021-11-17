package ioc.beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans_Beanscope.xml");

        //TODO:  SINGLETON Problem 1

        SecureMessage secureMessage1 = (SecureMessage) context.getBean("securemessage");
        secureMessage1.setMessage("I'm object of Singleton 1");
        secureMessage1.getMessage();

        SecureMessage secureMessage2 = (SecureMessage) context.getBean("securemessage");
        secureMessage2.setMessage("I'm object of Singleton 2");
        secureMessage2.getMessage();

        //there is only one object created for bean id="securemessage". it differs from actual singelton from core java.
        SecureMessage secureMessage3 = secureMessage1;
        secureMessage3.getMessage();


        //TODO:  SINGLETON Problem 2



        //TODO:  PROTOTYPE
        SecureMessage secureMessage13 = (SecureMessage) context.getBean("securemessage1");
        secureMessage13.setMessage("I'm object 3");
        secureMessage13.getMessage();

        SecureMessage secureMessage14 = (SecureMessage) context.getBean("securemessage1");
        //secureMessage14.setMessage("I'm object 4");
        secureMessage14.getMessage();

        SecureMessage secureMessage15 = (SecureMessage) context.getBean("securemessage1");
        secureMessage15.setMessage("I'm object 5");
        secureMessage15.getMessage();


    }
}
