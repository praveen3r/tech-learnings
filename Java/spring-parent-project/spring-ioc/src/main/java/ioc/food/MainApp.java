package ioc.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String str[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"SpringBeans_Food.xml"});

        Meal meal = context.getBean("mealByAnnotation", Meal.class);
        System.out.println("Spring Meal :-- " + meal.whatsIsInThisMeal());


//        Fruit fruit = context.getBean("fruit", Fruit.class);
//        System.out.println(fruit.talkAboutYourself());

//        Fruit anotherFruit = context.getBean("anotherFruit", Fruit.class);
//        System.out.println(anotherFruit.talkAboutYourself());


        ((ClassPathXmlApplicationContext) context).close();
    }
}
