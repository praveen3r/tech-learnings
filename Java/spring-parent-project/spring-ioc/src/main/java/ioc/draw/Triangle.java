package ioc.draw;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class Triangle extends ShapeAbstract implements ApplicationContextAware {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    private ApplicationContext applicationContext=null;

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Triangle(String type){
        this.type=type;
    }

    public void draw() {
        System.out.println("This is Triangle!");
        System.out.println("Type="+type);
    }

    public void drawPoints() {
        System.out.println("Point A:"+pointA.getX()+pointA.getY());
        System.out.println("Point B:"+pointB.getX()+pointB.getY());
        System.out.println("Point C:"+pointC.getX()+pointC.getY());
    }

    public void displayvalues() {
        for (String value: values
             ) {
            System.out.println(value);
        }
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
