package pureannotations.concepts.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan//(basePackages = "pureannotations.concepts.autowired")
public class MainApp {
    public static void main(String str[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //TODO : @Component
//Example 01 - get bean by name as ClassName
//        ATest a = context.getBean("ATest", ATest.class);
//        System.out.println(a);

//Example 02  - get bean by ClassName
//        ATest a = context.getBean(ATest.class);
//        System.out.println(a);

//Example 03  - get bean by  @Component ("FirstLetter") which will override the default value of ATest to FirstLetter.
//        ATest a = context.getBean("FirstLetter", ATest.class);
//        System.out.println(a);

        //TODO : @bean
//Example 01 - get bean by method name /default name.
//        CTest c = context.getBean("getC1", CTest.class);
//        System.out.println(c);

//Example 02 - get bean by given name as @Bean(name = "C2")
//        CTest c = context.getBean("C2", CTest.class);
//        System.out.println(c);

        //https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
        //TODO : @Autowired on Properties
//        ATest a = context.getBean(ATest.class);
//        System.out.println(a);
//        System.out.println(a.alphabet);
//        System.out.println(a.number);
        //TODO : @Autowired on Constructors

        ATest a = context.getBean(ATest.class);
        System.out.println(a);
//        System.out.println(a.alphabet);
        System.out.println(a.number);
        System.out.println(a.aCase);

        //TODO : @Autowired on method parameters

//        ATest a = context.getBean(ATest.class);
//        System.out.println(a.aCase);

        //TODO : @Autowired with (required = false) option
//        ATest a = context.getBean(ATest.class);
//        System.out.println(a);
//        System.out.println(a.alphabet);
//        System.out.println(a.number);
//        System.out.println(a.aCase);

        context.close();
    }
}
