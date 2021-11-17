package pureannotations.expression_language;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pureannotations.example3.HelloWorld;
import pureannotations.example3.HelloWorldConfig;

@ComponentScan("pureannotations.expression_language")
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(MainApp.class);
//        ctx.register(AppConfig.class, OtherConfig.class);
//        ctx.register(AdditionalConfig.class);
//        ctx.refresh();
        WorkersHolder workersHolder = ctx.getBean("workersHolder", WorkersHolder.class);
        System.out.println(workersHolder.getFirstWorker());


        Calculator calculator = ctx.getBean("calculator", Calculator.class);
        System.out.println(calculator.getAdd());

    }
}
