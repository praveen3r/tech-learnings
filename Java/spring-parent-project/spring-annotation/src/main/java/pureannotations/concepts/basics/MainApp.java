package pureannotations.concepts.basics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String str[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //TODO Check: No qualifying bean of type [pureannotations.concepts.basics.HelloBean] is defined: expected single matching bean but found 3: getHelloBean,helloByName1,helloByName2

        //HelloBean bean = context.getBean(HelloBean.class);
        //System.out.println(bean.hello());

        HelloBean bean1 = context.getBean("helloByName1", HelloBean.class);
        System.out.println(bean1.hello());

        HelloBean bean2 = context.getBean("helloByName2", HelloBean.class);
        System.out.println(bean2.hello());

        TestBean testBean = context.getBean(TestBean.class);
        System.out.println(testBean.test());


    }
}
