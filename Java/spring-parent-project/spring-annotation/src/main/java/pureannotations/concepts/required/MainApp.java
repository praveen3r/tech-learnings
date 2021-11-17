package pureannotations.concepts.required;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String str[]) {
        //TODO ERROR :Exception in thread "main" java.lang.IllegalStateException: org.springframework.context.annotation.AnnotationConfigApplicationContext@3f91beef has not been refreshed yet
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer = context.getBean(Customer.class);
        customer.setId(1000);
        System.out.println(customer.getId());
        System.out.println(customer.getName());

        Student student = (Student) context.getBean("student");
        System.out.println("Name : " + student.getName());
        System.out.println("Age : " + student.getAge());


    }
}
