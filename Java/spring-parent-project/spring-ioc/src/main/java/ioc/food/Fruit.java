package ioc.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Fruit implements Food {
    //No Arugment
    public Fruit() {

    }

    private String description = "Not Set";

    @Autowired
    public void setDescription(@Value("HI... I am a Fruit....My Description using the Annotation.") String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    public String talkAboutYourself() {
        return "I am Fruit" + getDescription();
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Start.... " + this.description);
    }

    @PreDestroy
    public void destoryMethod() {
        System.out.println("End.... Destroyed ");
    }
}
