package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.IdolCompetition.Performer.Performer;

/**
 * Created by ymukhin on 5/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring_IdolCompetition.xml");
        Performer performer = (Performer) ctx.getBean("eddie");
        performer.perform();
    }
}
