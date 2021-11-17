package ioc.draw;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MainApp {
    public static void main(String str[]) {


        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Skills Development\\workspace\\spring-parent-project\\spring-ioc\\src\\main\\resources\\SpringBeans_Draw.xml"));
        Shape shape = factory.getBean("triangle", Triangle.class);
        Shape shape1 = factory.getBean("circle", Circle.class);
        shape.draw();
        shape1.draw();

        Triangle trianglePoints = factory.getBean("trianglePoint", Triangle.class);
        trianglePoints.drawPoints();

        Triangle triangleValues = factory.getBean("triangleValues", Triangle.class);
        triangleValues.displayvalues();


        Triangle trianglePoints1 = factory.getBean("trianglePoint1", Triangle.class);
        trianglePoints1.drawPoints();


    }
}
