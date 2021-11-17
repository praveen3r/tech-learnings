package ioc;

import ioc.staticfactory.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

    private String name;

    private Test test;
    //    IndexOutOfBoundsException indexOutOfBoundsException;
//    ArrayList arrayList;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hi.. This is my First Spring project build with Maven for demo.");

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringBeans.xml"});

        //called by actual name/id
        //System.out.println((context.getBean("helloBean", HelloWorld.class)).getName());

        //called by alias name
        HelloWorld helloWorld = (context.getBean("hello", HelloWorld.class));
        System.out.println("1."+helloWorld.getName());
        helloWorld.setName("Sathya");

        System.out.println("2."+helloWorld.getName());

        HelloWorld helloWorld1 = (context.getBean("helloBean1", HelloWorld.class));

        System.out.println("3."+helloWorld1.getName());
        System.out.println("4."+helloWorld1.getTest().getName());
        System.out.println("5."+helloWorld.getName());

        /*HelloWorld helloWorld2 = (context.getBean("helloBean", HelloWorld.class));

        System.out.println(helloWorld2.getName());*/
        //System.out.println((context.getBean("helloBean1", HelloWorld.class)).getName());

        //System.out.println((context.getBean("helloBean", HelloWorld.class)).getName());

        Test test = context.getBean("test3", Test.class);
//        System.out.println(test.getName());

        //empty

        HelloWorld empty = (HelloWorld) context.getBean("null");
//        System.out.println(empty.getName());

    }

}

//TODO : OUTPUT
//    Spring Master!!!
