package ioc.examples.example1.college;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans_College.xml");

        Profile profile = (Profile) context.getBean("profile");
        profile.printAge();
        profile.printName();

        Student student_1 = context.getBean("student1", Student.class);
        System.out.println(student_1.getAge() + "------------" + student_1.getName());


        Student student_2 = context.getBean("student2", Student.class);
        System.out.println(student_2.getAge() + "------------" + student_2.getName());


    }
}