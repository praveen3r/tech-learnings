package ioc.container;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class MainApp {
    public static void main(String[] args) {

        // File system resource
        ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("SourceCode/xml/beans.xml");
        Book myFirstSpringBook1 = (Book) applicationContext1.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook1.getTitle().getTitleValue());

        // Multiple File system resource
        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext(
                "SourceCode/xml/books.xml",
                "SourceCode/xml/chapters.xml",
                "SourceCode/xml/titles.xml");
        Book myFirstSpringBook2 = (Book) applicationContext2.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook2.getTitle().getTitleValue());

        // File system resource
        ApplicationContext applicationContext3 = new FileSystemXmlApplicationContext("SourceCode/xml/myAppBeans.xml");
        Book myFirstSpringBook3 = (Book) applicationContext3.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook3.getTitle().getTitleValue());

        // Class path resource
        ApplicationContext applicationContext4 = new ClassPathXmlApplicationContext("beans.xml");
        Book myFirstSpringBook4 = (Book) applicationContext4.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook4.getTitle().getTitleValue());

        // Multiple Class path resource
        ApplicationContext applicationContext5 = new ClassPathXmlApplicationContext(
                "books.xml",
                "chapters.xml",
                "titles.xml");
        Book myFirstSpringBook5 = (Book) applicationContext5.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook5.getTitle().getTitleValue());

        // Class path resource
        ApplicationContext applicationContext6 = new ClassPathXmlApplicationContext("myAppBeans.xml");
        Book myFirstSpringBook6 = (Book) applicationContext6.getBean("myFirstSpringBook");
        System.out.println(myFirstSpringBook6.getTitle().getTitleValue());

        ((ClassPathXmlApplicationContext)applicationContext6).close();

    }

}