package pureannotations.com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@ComponentScan("pureannotations.com.demo")
@Order
public class MainApp {
    public static void main(String str){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        //context
    }
}

